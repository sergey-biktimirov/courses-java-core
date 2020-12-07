package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

public abstract class Field {
    Cell[][] cellList;

    /**
     * Размер поля
     */
    int width, height;

    /**
     * Конструктор для не квадратного поля
     *
     * @param width  ширина поля (в ячейках)
     * @param height высота поля (в ячейках)
     */
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Конструктор для квадратного поля
     *
     * @param size Квадратный размер поля (в ячейках)
     */
    public Field(int size) {
        width = height = size;
    }

    abstract void createField();

    abstract void paintField();

}
