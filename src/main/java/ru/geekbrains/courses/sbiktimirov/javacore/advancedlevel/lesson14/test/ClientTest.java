package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.test;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson14.client.ConsoleClient;

import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        ConsoleClient consoleClient = new ConsoleClient("localhost", 5000);
    }
}
