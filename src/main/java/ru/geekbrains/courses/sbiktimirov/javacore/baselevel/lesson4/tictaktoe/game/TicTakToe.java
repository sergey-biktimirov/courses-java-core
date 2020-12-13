package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.CellIsNotEmptyException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ToManyPlayersException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ToSmallFieldSizeException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.WrongCoordinateException;

public abstract class TicTakToe {

    public int MAX_PLAYERS = 2;
    private final int MIN_FIELD_SIZE = 3;

    public Field field;
    private int playerCount;

    public Field getField() {
        return field;
    }

    public void setField(Field field) throws ToSmallFieldSizeException {
        this.field = field;
        checkFieldSize(this.field.width);
        checkFieldSize(this.field.height);
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
        if (size < MIN_FIELD_SIZE){
            throw new ToSmallFieldSizeException("Поле слишком маленького размера, играть на таком не получится");
        }
    }

    public void makeMove(int x, int y) throws WrongCoordinateException, CellIsNotEmptyException {
        field.makeMove(x, y);
    }

}
