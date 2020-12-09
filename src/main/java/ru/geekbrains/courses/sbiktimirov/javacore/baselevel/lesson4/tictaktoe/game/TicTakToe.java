package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.ConsoleGameTickTakToeField;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ToManyPlayersException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ToSmallFieldSizeException;

public abstract class TicTakToe {

    public int MAX_PLAYERS = 2;

    private Field field;
    private int playerCount;

    public Field getField() {
        return field;
    }

    public void setField(Field field) throws ToSmallFieldSizeException {
        checkFieldSize(field.width);
        checkFieldSize(field.height);
        this.field = field;
    }

    protected void setPlayerCount(int players) throws ToManyPlayersException {
        if (players > MAX_PLAYERS || players < 0) {
            throw new ToManyPlayersException("Максимально количество игроков - " + MAX_PLAYERS);
        }
        playerCount = players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void checkFieldSize(int size) throws ToSmallFieldSizeException {
        if (size < 3){
            throw new ToSmallFieldSizeException("Поле слишком маленького размера, играть на таком не получится");
        }
    }

}
