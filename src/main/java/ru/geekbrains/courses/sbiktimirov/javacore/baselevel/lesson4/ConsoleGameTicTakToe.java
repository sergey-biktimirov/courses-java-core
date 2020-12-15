package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.TicTakToe;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.*;

import java.io.InputStream;
import java.util.Scanner;

class ConsoleGameTicTakToe extends TicTakToe {

    Scanner scanner;
    ConsoleGameTickTakToeField consoleField = new ConsoleGameTickTakToeField(3);
    /**
     * Текущий ход
     * move[0] - координата x
     * move[1] - координата y
     */
    int[] move = {-1, -2};

    /**
     * Символы игроков
     * */
    private char[] playerChar = ConsoleGameTickTakToeCell.charList;

    public ConsoleGameTicTakToe(InputStream is) {
        super();
        scanner = new Scanner(is);
        welcomeMsg();
        printMenu();
        newGame();
    }

    /**
     * Выход из игры.
     */
    private void exitGame() {
        scanner.close();
        System.exit(0);
    }

    /**
     * Запуск игры
     * */
    public void startConsoleGame() {
        super.startGame();
        field.paintField();
        while (!field.isGameOver || field.movesLeft != 0) {
            makeMove();
        }

    }


    /**
     * Получить символ игрока выполняющего ход
     * */
    public char getPlayerChar() {
        return playerChar[field.getPlayerTurn()];
    }

    /**
     * Получить символ игрока выполняющего ход
     * @param i - номер символа игрока 0 - пустое поле, 1 - нолик, 2 - крестик
     * */
    public char getPlayerChar(int i) {
        return playerChar[i];
    }

    /**
     * Сообщение для игрока выполняющего ход
     * */
    public void printWhoIsMove() {
        System.out.printf("Ходит %s: %n", getPlayerChar());
    }

    /**
     * Диалог ввода номера строки поля
     * */
    public void enterX() {
        try {
            System.out.println("Введите номер колонки");
            inputMsg();
            move[0] = playerInput() - 1;
            field.checkXCoordinate(move[0]);
        } catch (WrongCoordinateException e) {
            printErr(e.getLocalizedMessage());
            enterX();
        }
    }


    /**
     * Диалог ввода номера строки поля
     * */
    public void enterY() {
        try {
            System.out.println("Введите номер строки");
            inputMsg();
            move[1] = playerInput() - 1;
            field.checkYCoordinate(move[1]);
        } catch (WrongCoordinateException e) {
            printErr(e.getLocalizedMessage());
            enterY();
        }
    }

    /**
     * Диалог выполнения хода]
     * */
    public void makeMove() {
        printWhoIsMove();
        enterX();
        enterY();
        try {
            super.makeMove(move[0], move[1]);
            field.paintField();
            makeMove();
        } catch (CellIsNotEmptyException | WrongCoordinateException e) {
            printErr(e.getLocalizedMessage());
            makeMove();
        } catch (TickTacToeGameOverException e) {
            gameOver(e);
        }
    }

    /**
     * Обработка завершения игры
     */
    public void gameOver(TickTacToeGameOverException gameOver) {
        field.paintField();
        printErr(gameOver.getLocalizedMessage());
        if (gameOver.getWinner() != 0) {
            System.out.printf("Победил %s: %n", getPlayerChar(gameOver.getWinner()));
        } else {
            System.out.println("Победила дружба!");
        }
        printMenu();
        newGame();
    }

    /**
     * Вывод в консоль сообщения приветсвия.
     */
    private void welcomeMsg() {
        System.out.println("Добро пожаловать в игру \"Крестики нолики\"");
    }

    /**
     * Вывод в консоль меню игры.
     */
    private void printMenu() {
        System.out.println("Введите: /q - для выхода\n" +
                "         /n - для начала новой игры\n" +
                "         /m - для вывода меню");
    }

    /**
     * Обработка ввода количества игроков.
     */
    private void enterPlayerCountMsg() {
        System.out.println("Введите количество игроков (максимум 2 игрока).");
        inputMsg();
        try {
            setPlayerCount(playerInput());
        } catch (ToManyPlayersException e) {
            printErr(e.getLocalizedMessage());
            newGame();
        }
    }

    /**
     * Обработка ввода размеров поля.
     */
    private void enterFieldSizeMsg() {
        System.out.println("Введите размер поля, поле должно иметь размер больше 3x3 ячейки.");
        try {
            setField(consoleField);
        } catch (ToSmallFieldSizeException e) {
            e.printStackTrace();
        }
        enterFieldWidth();
        enterFieldHeight();
    }

    /**
     * Обработка ввода ширины поля.
     */
    public void enterFieldWidth() {
        System.out.println("Введите ширину поля.");
        inputMsg();
        try {
            field.width = playerInput();
            checkFieldSize(field.width);
        } catch (ToSmallFieldSizeException e) {
            printErr(e.getLocalizedMessage());
            enterFieldWidth();
        }
    }

    /**
     * Обработка ввода высоты поля.
     */
    public void enterFieldHeight() {
        System.out.println("Введите высоту поля.");
        inputMsg();
        try {
            field.height = playerInput();
            checkFieldSize(field.height);
        } catch (ToSmallFieldSizeException e) {
            printErr(e.getLocalizedMessage());
            enterFieldHeight();
        }
    }

    /**
     * Курсор ввода игрока
     */
    private void inputMsg() {
        System.out.print(">: ");
    }

    /**
     * Кастомный курсор ввода игрока
     */
    private void inputMsg(String cursor) {
        System.out.print(cursor);
    }

    /**
     * Начало новой игры.
     */
    public void newGame() {
        enterPlayerCountMsg();
        enterFieldSizeMsg();
        try {
            setField(field);
        } catch (ToSmallFieldSizeException e) {
            printErr(e.getLocalizedMessage());
            newGame();
        }
        startConsoleGame();
    }

    /**
     * Вывод в консоль сообщения об ошибки ввода игрока.
     *
     * @param err Текст сообщения об ошибки.
     */
    private void printErr(String err) {
        System.err.println(err);
        delay(50);
    }

    /**
     * Задержка главного потока для упорядочивания вывода в консоль.
     *
     * @param n задержка мс.
     */
    private void delay(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Обработка ввода игрока.
     */
    private int playerInput() {
        String line = scanner.nextLine().trim();
        switch (line) {
            case "/q":
                exitGame();
                break;
            case "/n":
                newGame();
                break;
            case "/m":
                printMenu();
                break;
        }
        int n = -1;
        try {
            n = Integer.parseInt(line);
        } catch (Exception e) {
            printErr("Введено не число, введите число.");
        }
        return n;
    }
}