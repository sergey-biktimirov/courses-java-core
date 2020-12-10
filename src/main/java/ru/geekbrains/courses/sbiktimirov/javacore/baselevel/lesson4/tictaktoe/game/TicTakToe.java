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
    /**
     * Кто ходит - false крестик, true нолик
     * */
    public boolean isZeroMove = false;

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
        checkXCoordinate(x);
        checkYCoordinate(y);
        checkCell(x, y);
        field.cellList[y][x].setValue((isZeroMove = !isZeroMove) ? 2 : 1);
    }

    private void checkCell(int x, int y) throws CellIsNotEmptyException {
        if(field.cellList[y][x].getValue() != 0){
            throw new CellIsNotEmptyException("Ячейка уже занята, укажите другую");
        }
    }

    public void checkXCoordinate(int coordinate) throws WrongCoordinateException {
        if (coordinate < 0 || coordinate >= field.width){
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

    public void checkYCoordinate(int coordinate) throws WrongCoordinateException {
        if (coordinate < 0 || coordinate >= field.height){
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

}
