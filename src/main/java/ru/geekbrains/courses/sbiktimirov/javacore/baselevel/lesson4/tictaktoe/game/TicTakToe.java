package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.ConsoleGameTickTakToeField;

public abstract class TicTakToe {

    public int MAX_PLAYERS = 2;

    public Field field;
    public int playerCount;

    public String start(int width, int height, int players) {
        field = new ConsoleGameTickTakToeField(width, height);
        return setPlayerCount(players);
    }

    public String start(int size, int players) {
        field = new ConsoleGameTickTakToeField(size);
        return setPlayerCount(players);
    }

    protected String setPlayerCount(int players) {
        if (playerCount > MAX_PLAYERS || playerCount < 0) {
            return "Максимально количество игроков - " + MAX_PLAYERS;
        } else {
            return "Игра на двоих";
        }
    }

    public abstract void newGame();
}
