package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game;

public abstract class Field {
    public Cell[][] cellList;

    /**
     * Размер поля
     */
    public int width;
    public int height;

    /**
     * Игра окончена - true - Да, false - Нет
     * */
    public boolean isGameOver = false;

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

    public void createField(){
        cellList = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cellList[i][j] = new Cell(this, j, i);
            }
        }
    };

    public abstract void paintField();

}
