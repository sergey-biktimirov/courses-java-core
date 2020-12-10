package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

import java.util.Arrays;

public class Cell {
    /**
     * Ссылка на поле
     */
    Field field;
    /**
     * Ссылка левую ячейку
     */
    private Cell leftCell;
    /**
     * Ссылка на верхнюю левую ячейку
     */
    private Cell topLeftCell;
    /**
     * Ссылка на верхнюю ячейку
     */
    private Cell topCell;
    /**
     * Ссылка на верхнюю правую ячейку
     */
    private Cell topRightCell;
    /**
     * Ссылка нижнюю левую ячейку
     */
    private Cell bottomLeftCell;
    /**
     * Ссылка нижнюю ячейку
     */
    private Cell bottomCell;
    /**
     * Ссылка нижнюю правую ячейку
     */
    private Cell bottomRightCell;
    /**
     * Ссылка на правую ячейку
     */
    private Cell rightCell;
    /**
     * Текущее положение ячейки по осям x и y.
     * По умолчанию -1, не задано.
     */
    int x, y;

    /**
     * Числовое значение ячейки
     * 0, ячейка пустая
     * 1, в ячейке нолик
     * 2, в ячейке крестик
     */
    private int value = 0;

    /**
     * Главный конструктор
     *
     * @param field Ссылка на поле в котором находится ячейка
     * @param x     Координата по оси x
     * @param y     Координата по оси y
     */
    public Cell(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
    }

    /**
     * Обзор ячеек вокруг текущей
     */
    private void lookAround() {
        leftCell = x - 1 >= 0 ? field.cellList[y][x - 1] : null;

        rightCell = x + 1 < field.width ? field.cellList[y][x + 1] : null;

        topLeftCell = x - 1 >= 0 && y - 1 >= 0 ? field.cellList[y - 1][x - 1] : null;

        topCell = y - 1 >= 0 ? field.cellList[y - 1][x] : null;

        topRightCell = y - 1 >= 0 && x + 1 < field.width ? field.cellList[y - 1][x + 1] : null;

        bottomLeftCell = y + 1 < field.height && x - 1 >= 0 ? field.cellList[y + 1][x - 1] : null;

        bottomCell = y + 1 < field.height ? field.cellList[y + 1][x] : null;

        bottomRightCell = y + 1 < field.height && x + 1 < field.width ? field.cellList[y + 1][x + 1] : null;
    }

    public void setValue(int value) {
        this.value = value;
        lookAround();
        findWinner();
    }

    public int getValue() {
        return value;
    }

    private void findWinner() {
    }

}
