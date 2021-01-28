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
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class AuthService extends Messenger implements Runnable {
    private final Socket socket;
    private final ConsoleServer server;
    private static final ConcurrentHashMap<String, User> userList = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i < 9; i++) {
            userList.put("User" + i, new User("User" + i, "User" + i));
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
                if (server.getClients().get(msg.getFromUserName()) == null) {
                    //TODO ActionType.SIGNOUT/SIGNIN
                    if (signIn(msg.getFromUserName(), msg.getMessage())) {
                        server.addClient(
                                msg.getFromUserName(),
                                new ServerClient(socket, server, msg.getFromUserName()));
                        sendSuccessSignIn(msg.getFromUserName());
                    } else {
                        sendErrorSignIn(msg.getFromUserName());
                    }
                } else {
                    sendSuccessSignIn(msg.getFromUserName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean signIn(String userName, String password) {
        return userList.get(userName).checkPassword(password);
    }

    //TODO SIGNOUT

    private void sendSuccessSignIn(String username) throws IOException {
        sendMessage(new Message()
                .setMessageType(MessageType.AUTH)
                .setFromUserName(server.getServerName())
                .setResponseCode(ResponseCode.OK)
                .setToUsername(username)
                .setMessage("Вы авторизованы"));
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
