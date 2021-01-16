package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson4.app.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ChatController {

    public TextArea msgTextField;
    public Button sendMsgButton;
    public ListView<String> chatContent;

    private ObservableList<String> msgList = FXCollections.observableArrayList();

    public void sendMessage() {
        if (msgTextField.getText().length() > 0) {
            msgList.add(msgTextField.getText());
            msgTextField.setText("");
            chatContent.scrollTo(msgList.size() - 1);
        }
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
    }
}
