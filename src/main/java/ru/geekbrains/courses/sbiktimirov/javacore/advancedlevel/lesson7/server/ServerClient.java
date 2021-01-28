package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Messenger;

public class ServerClient extends Messenger {

    private final Socket socket;
    private final ConsoleServer server;
    private final String userName;

    public ServerClient(Socket socket, ConsoleServer server, String userName) {
        this.socket = socket;
        this.server = server;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
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
