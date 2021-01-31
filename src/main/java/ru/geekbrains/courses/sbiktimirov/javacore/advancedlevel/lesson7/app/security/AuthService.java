package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.security;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Message;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.MessageType;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Messenger;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.ResponseCode;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server.ConsoleServer;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server.ServerClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class AuthService extends Messenger implements Runnable {
    private final Socket socket;
    private final ConsoleServer server;
    private static final ConcurrentHashMap<String, User> userList = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i < 9; i++) {
            userList.put("user" + i, new User("User" + i, "User" + i));
        }
    }

    public AuthService(Socket socket, ConsoleServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            Message msg = getMessage();

            if (msg.getMessageType() == MessageType.AUTH) {
                server.logger.info("Попытка авторизации " + msg.toString());
                if (server.getClientByUsername(msg.getFromUserName()) == null) {
                    //TODO ActionType.SIGNOUT/SIGNIN
                    User user = signIn(msg.getFromUserName(), msg.getMessage());
                    if (user != null) {
                        sendSuccessSignIn(msg.getFromUserName());

                        server.addClient(
                                user,
                                new ServerClient(socket, server, user));

                        server.logger.info("Пользователь авторизовался " + msg.toString());
                    } else {
                        sendErrorSignIn(msg.getFromUserName());

                        server.logger.warning("Пользователь не авторизован " + msg.toString());
                    }
                } else {
                    sendSuccessSignIn(msg.getFromUserName());

                    server.logger.info("Пользователь <" +  msg.getFromUserName() + "> уже авторизован");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            server.logger.severe(e.getMessage());
        }
    }

    private User signIn(String userName, String password) {
        User user = null;
        try {
            User _user = userList.get(userName.toLowerCase());
            if(_user.checkPassword(password)) user = _user;
        } catch (Exception e) {
            server.logger.info("Пользователь <" + userName + "> не найден");
        }
        return user;
    }

    //TODO SIGNOUT

    private void sendSuccessSignIn(String username) throws IOException {
        sendMessage(new Message()
                .setMessageType(MessageType.AUTH)
                .setFromUserName(server.getServerName())
                .setResponseCode(ResponseCode.OK)
                .setToUsername(username)
                .setMessage("Вы авторизованы. \n Введите \\w !имя пользователя! !сообщение! для отправки личного сообщения."));
    }

    private void sendErrorSignIn(String username) throws IOException {
        sendMessage(new Message()
                .setMessageType(MessageType.AUTH)
                .setFromUserName(server.getServerName())
                .setResponseCode(ResponseCode.ERROR)
                .setToUsername(username)
                .setMessage("Ошибка логина или пароля"));
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
