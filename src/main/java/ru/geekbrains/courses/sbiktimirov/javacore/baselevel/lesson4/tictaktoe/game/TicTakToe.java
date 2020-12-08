package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.ConsoleGameTickTakToeField;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToManyPlayers;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToSmallFieldSize;

public abstract class TicTakToe {

    public int MAX_PLAYERS = 2;

    public Field field;
    public int playerCount;

    public String start(int width, int height, int players) throws ExceptionToManyPlayers, ExceptionToSmallFieldSize {
        checkFieldSize(width, height);
        field = new ConsoleGameTickTakToeField(width, height);
        return setPlayerCount(players);
    }

    public String start(int size, int players) throws ExceptionToManyPlayers, ExceptionToSmallFieldSize {
        checkFieldSize(size, size);
        field = new ConsoleGameTickTakToeField(size);
        return setPlayerCount(players);
    }

    public void checkFieldSize(int width, int height) throws ExceptionToSmallFieldSize {
        if (width < 3 || height < 3){
            throw new ExceptionToSmallFieldSize("Поле слишком маленького размера, играть на таком не получится");
        }
    }

    protected String setPlayerCount(int players) throws ExceptionToManyPlayers {
        String msg;
        if (players > MAX_PLAYERS || players < 0) {
            throw new ExceptionToManyPlayers("Максимально количество игроков - " + MAX_PLAYERS);
        } else if (players == 1) {
            msg = "Игра с ботом";
        } else {
            msg = "Игра на двоих";
        }
        playerCount = players;
        return msg;
    }

    public abstract void newGame();
}
