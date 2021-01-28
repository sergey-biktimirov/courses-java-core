package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.server.ConsoleServer;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        ConsoleServer server = new ConsoleServer(5000);
    }
}
