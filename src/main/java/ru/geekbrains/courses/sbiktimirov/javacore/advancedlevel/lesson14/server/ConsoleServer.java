package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.server;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.messanger.ConsoleMessenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class ConsoleServer {

    private final ServerSocket serverSocket;
    private final UUID uuid;

    public ConsoleServer(UUID uuid, int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.uuid = uuid;
        start();
    }

    public ConsoleServer(int port) throws IOException {
        this(UUID.randomUUID(), port);
    }

    private void start() throws IOException {

        System.out.println("Сервер запущен.");
        Socket socket = serverSocket.accept();

        Scanner scanner = new Scanner(System.in);

        ConsoleMessenger consoleMessenger = new ConsoleMessenger(uuid, socket, scanner);
        consoleMessenger.startReader();
        consoleMessenger.startWriter();

        System.out.printf("Клиент %s подключен.%n", consoleMessenger.getUuid());

//        System.exit(0);
    }
}
