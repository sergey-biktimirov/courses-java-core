package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.CellIsNotEmptyException;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.TickTacToeGameOverException;
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

    /**
     * Создание поле
     */
    public void createField() {
        isGameOver = false;
        isZeroMove = false;
        winner = 0;
        isHadWinner = false;
        setMovesLeft();
        cellList = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cellList[i][j] = new Cell(this, j, i);
            }
        }
    }

    /**
     * Установка остатка ходов
     */
    protected void setMovesLeft() {
        this.movesLeft = width * height;
    }

    /**
     *
     */
    public abstract void paintField();

    /**
     * Сделать ход
     *
     * @param x Координата по оси x
     * @param y Координата по оси y
     * @throws WrongCoordinateException - если введены не корректные координаты
     * @throws CellIsNotEmptyException  - если в ячейку был сделан ход
     */
    public void makeMove(int x, int y) throws WrongCoordinateException, CellIsNotEmptyException, TickTacToeGameOverException {
        checkXCoordinate(x);
        checkYCoordinate(y);
        checkCell(x, y);
        this.cellList[y][x].setValue(getPlayerTurn());
        movesLeft -= 1;
        if (isGameOver || movesLeft == 0) {
            throw new TickTacToeGameOverException("Игра окончена", winner);
        }
        setPlayerTurn();
    }

    /**
     * Получить значение игрока, который должен выполнить ход
     */
    public int getPlayerTurn() {
        return isZeroMove ? 1 : 2;
    }

    /**
     * Переключить ход игрока
     */
    private void setPlayerTurn() {
        isZeroMove = !isZeroMove;
    }

    /**
     * Проверка был ли выполнен ход в ячейку
     *
     * @param x Координата по оси x
     * @param y Координата по оси y
     * @throws CellIsNotEmptyException - если в ячейку был сделан ход
     */
    void checkCell(int x, int y) throws CellIsNotEmptyException {
        if (this.cellList[y][x].getValue() != 0) {
            throw new CellIsNotEmptyException("Ячейка уже занята, укажите другую");
        }
    }

    /**
     * Проверка координаты по оси x
     *
     * @param x Координата по оси x
     * @throws WrongCoordinateException - если введены не корректные координаты
     */
    public void checkXCoordinate(int x) throws WrongCoordinateException {
        if (x < 0 || x >= this.width) {
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

    /**
     * Проверка координаты по оси y
     *
     * @param y Координата по оси y
     * @throws WrongCoordinateException - если введены не корректные координаты
     */
    public void checkYCoordinate(int y) throws WrongCoordinateException {
        if (y < 0 || y >= this.height) {
            throw new WrongCoordinateException("Значение выходит за пределы поля");
        }
    }

}
