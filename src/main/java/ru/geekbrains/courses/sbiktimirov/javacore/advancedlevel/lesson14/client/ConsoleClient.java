package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.client;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.messanger.ConsoleMessenger;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class ConsoleClient extends ConsoleMessenger {

    public ConsoleClient(UUID uuid, String host, int port) throws IOException {
        super(uuid, new Socket(host, port), new Scanner(System.in));
        start();
    }

    public ConsoleClient(String host, int port) throws IOException {
        this(UUID.randomUUID(), host, port);
    }

    private void start() {
        startReader();
        startWriter();
    }
}
