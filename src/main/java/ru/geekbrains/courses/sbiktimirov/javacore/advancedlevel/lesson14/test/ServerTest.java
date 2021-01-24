package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.test;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.server.ConsoleServer;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        ConsoleServer server = new ConsoleServer(5000);
    }
}
