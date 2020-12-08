package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.TicTakToe;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToManyPlayers;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToSmallFieldSize;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

class ConsoleGameTicTakToe extends TicTakToe {

    Scanner scanner;

    public ConsoleGameTicTakToe(InputStream is) {
        scanner = new Scanner(is);

        welcomeMsg();
        printMenu();
        enterPlayerCountMsg();
        inputMsg();

        while (scanner.hasNext()) {
            String in = scanner.nextLine().trim();
            if (in.equals("/q")) {
                exitGame();
            } else if (in.equals("/n")) {
                newGame();
            } else if (in.equals("/m")) {
                printMenu();
            } else {
                System.out.println(Arrays.toString(in.split(" ")));
            }

            inputMsg();
        }
    }

    private void exitGame() {
        scanner.close();
        System.exit(0);
    }

    public void startConsoleGame(int size, int players) {
        try {
            System.out.println(super.start(size, players));
        } catch (Exception e) {
            if (e instanceof ExceptionToManyPlayers) {
                System.out.println(e.getLocalizedMessage());
            } else if (e instanceof ExceptionToSmallFieldSize) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    public void startConsoleGame(int width, int height, int players) {
        try {
            super.start(width, height, players);
        } catch (Exception e) {
            if (e instanceof ExceptionToManyPlayers) {
                System.out.println(e.getLocalizedMessage());
            } else if (e instanceof ExceptionToSmallFieldSize) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    private void welcomeMsg() {
        System.out.println("Добро пожаловать в игру \"Крестики нолики\"");
    }

    private void printMenu() {
        System.out.println("Введите: /q - для выхода\n" +
                "         /n - для начала новой игры\n" +
                "         /m - для вывода меню");
    }

    private void enterPlayerCountMsg() {
        System.out.println("Введите колисество игроков");
    }

    private void enterFieldSizeMsg() {
        System.out.println("Введите размер поля, поле должно иметь размер больше трех ячеек.\n" +
                "Пример: 3   - для поля размером 3x3 ячейки\n" +
                "Пример: 3 4 - для поля размером 3x4 ячейки");
    }

    private void inputMsg() {
        System.out.print(">: ");
    }

    @Override
    public void newGame() {
    }
}