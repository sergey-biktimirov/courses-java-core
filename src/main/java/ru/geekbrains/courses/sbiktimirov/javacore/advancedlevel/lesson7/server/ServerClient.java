package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.security.User;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Message;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Messenger;

public class ServerClient extends Messenger {

    private final Socket socket;
    private final ConsoleServer server;
    private final User user;

    public ServerClient(Socket socket, ConsoleServer server, User user) {
        this.socket = socket;
        this.server = server;
        this.user = user;
        this.startReader();
    }

    public void startReader() {
        Thread reader = new Thread(() -> {
            while (true) {
                try {
                    Message msg = getMessage();
                    server.sendMessage(msg);
                    server.logger.info(msg.toString());
                } catch (Exception e) {
                    String errMsg = e.getLocalizedMessage();
                    server.logger.warning(errMsg == null ? "Connection is closed" : errMsg);
                    server.removeClient(getUserName());
                    break;
                }
            }
        });
        reader.start();
    }

    public String getUserName() {
        return user.getUsername();
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
