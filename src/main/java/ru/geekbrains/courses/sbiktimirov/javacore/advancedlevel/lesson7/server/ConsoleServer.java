package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.security.AuthService;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.Message;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.messanger.MessageType;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.UUID;

public class ConsoleServer extends Thread {

    private final ServerSocket serverSocket;
    private final String serverName;
    private boolean isClosed = false;
    private final HashMap<String, ServerClient> clients = new HashMap<>();

    public ConsoleServer(String serverName, int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.serverName = serverName;
        start();
    }

    public ConsoleServer(int port) throws IOException {
        this(UUID.randomUUID().toString(), port);
    }

    public void start() {
        super.start();
        //TODO Обработка команд с консоли
    }

    public String getServerName() {
        return serverName;
    }

    private void userConnected(ServerClient serverClient) {
//        new Thread(() -> {
            clients.forEach((s, serverClient1) -> {
                try {
                    Message msg = new Message()
                            .setMessageType(MessageType.INFO)
                            .setMessage(String.format("<%s> подключился к чату", serverClient.getUserName()));
                    serverClient.sendMessage(msg);

                    log(msg.toString());
                } catch (IOException e) {
                    clients.remove(serverClient.getUserName());
                }
            });
//        }).start();
    }

    private void userDisconnected(ServerClient serverClient) {
        new Thread(() -> {
            getClients().forEach((s, serverClient1) -> {
                try {
                    Message msg = new Message()
                            .setMessageType(MessageType.INFO)
                            .setMessage(String.format("<%s> подключился вышел из чата", serverClient.getUserName()));
                    serverClient.sendMessage(msg);

                    log(msg.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }).start();
    }

    synchronized public void addClient(String username, ServerClient serverClient) {
        clients.put(serverClient.getUserName(), serverClient);
        userConnected(serverClient);
    }

    synchronized public HashMap<String, ServerClient> getClients() {
        return clients;
    }

    public static void log(String s) {
        System.out.println("LOG: " + s);
    }

    @Override
    public void run() {
        System.out.println("Сервер запущен.");
        while (!isClosed) {
            try {
                new Thread(new AuthService(serverSocket.accept(), this)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
