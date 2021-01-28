package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Message;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.MessageType;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Messenger;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.ResponseCode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatController extends Messenger {

    public TextArea msgTextField;
    public Button sendMsgButton;
    public ListView<String> chatContent;
    public TextField loginField;
    public TextField passwordField;
    public Button connectButton;

    private ObservableList<String> msgList = FXCollections.observableArrayList();

    private Socket socket;

    public void sendMessage() {
        if (msgTextField.getText().length() > 0) {
            Message msg = new Message().setFromUserName(loginField.getText()).setMessageType(MessageType.MESSAGE)
                    .setMessage(msgTextField.getText());
            try {
                super.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            msgTextField.setText("");
        }
    }

    public void connect() {
        try {
            socket = new Socket("localhost", 5000);

            Message msg = new Message().setFromUserName(loginField.getText()).setMessageType(MessageType.AUTH).setMessage(passwordField.getText());

            super.sendMessage(msg);

            msg = getMessage();

            msgList.add(msg.toString());

            if (msg.getResponseCode() == ResponseCode.ERROR){
                //TODO Сообщение об ошибке подключения и зачистка пароля
            } else {
                startReader();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startReader() {
        Thread reader = new Thread(() -> {
            //TODO Добавить завершение сеанса после закрытия приложения
            while (true) {
                //TODO Обработка MessageType.*
                try {
                    Message msg = getMessage();
                    msgList.add(msg.toString());
                    chatContent.scrollTo(msgList.size() - 1);
                } catch (Exception e) {
                    String errMsg = e.getLocalizedMessage();
                    msgList.add(String.format("Ошибка: %s", errMsg == null ? "Connection is closed" : errMsg));
                    //TODO Сообщение об ошибке и переход к экрану ввода логина и пароля
                    break;
                }
            }
        });
        reader.start();
    }

    @FXML
    public void initialize() {
        chatContent.setItems(msgList);

        sendMsgButton.setOnAction(event -> sendMessage());
        sendMsgButton.setDefaultButton(true);

        msgTextField.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        sendMessage();
                    }
                }
        );

        connectButton.setOnAction(event -> connect());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }
}
