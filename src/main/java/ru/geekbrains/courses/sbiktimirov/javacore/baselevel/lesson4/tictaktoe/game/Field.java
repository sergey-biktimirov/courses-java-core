package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.CellIsNotEmptyException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.WrongCoordinateException;

public abstract class Field {
    public Cell[][] cellList;

    /**
     * Размер поля
     */
    public int width;
    public int height;

    /**
     * Игра окончена - true - Да, false - Нет
     */
    public boolean isGameOver = false;

    /**
     * Кто ходит - false крестик, true нолик
     */
    public boolean isZeroMove = false;

    /**
     * Победитель - 0 - Нет победителя, 1 - победитель нолик, 2 - победитель крестик
     */
    public int winner = 0;

    /**
     * Есть победитель? - true - Да, false - Нет.
     */
    public boolean isHadWinner = false;

    /**
     * Осталось ходов
     */
    public int movesLeft = 0;

    /**
     * Конструктор для не квадратного поля
     *
     * @param width  ширина поля (в ячейках)
     * @param height высота поля (в ячейках)
     */
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        setMovesLeft();
    }

    /**
     * Конструктор для квадратного поля
     *
     * @param size Квадратный размер поля (в ячейках)
     */
    public Field(int size) {
        width = height = size;
        setMovesLeft();
    }

    public void createField() {
        setMovesLeft();
        cellList = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cellList[i][j] = new Cell(this, j, i);
            }
        }
    }

    private void setMovesLeft() {
        this.movesLeft = width * height;
    }

    public abstract void paintField();

    public void makeMove(int x, int y) throws WrongCoordinateException, CellIsNotEmptyException {
        checkXCoordinate(x);
        checkYCoordinate(y);
        checkCell(x, y);
        this.cellList[y][x].setValue((isZeroMove = !isZeroMove) ? 2 : 1);
        movesLeft -= 1;
    }

    void checkCell(int x, int y) throws CellIsNotEmptyException {
        if (this.cellList[y][x].getValue() != 0) {
            throw new CellIsNotEmptyException("Ячейка уже занята, укажите другую");
        }
    }

    public void checkXCoordinate(int coordinate) throws WrongCoordinateException {
        if (coordinate < 0 || coordinate >= this.width) {
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

    public void checkYCoordinate(int coordinate) throws WrongCoordinateException {
        if (coordinate < 0 || coordinate >= this.height) {
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

}
