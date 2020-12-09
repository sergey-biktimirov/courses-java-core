package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

public abstract class Cell {
    /**
     * Ссылка на поле
     */
    Field field;
    /**
     * Ссылка левую ячейку
     */
    Cell leftCell;
    /**
     * Ссылка на верхнюю ячейку
     */
    Cell topCell;
    /**
     * Ссылка нижнюю ячейку
     */
    Cell bottomCell;
    /**
     * Ссылка на правую ячейку
     */
    Cell rightCell;
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
    public int value = 0;

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

    private void lookAround() {
    }

    public abstract void paint();

}
