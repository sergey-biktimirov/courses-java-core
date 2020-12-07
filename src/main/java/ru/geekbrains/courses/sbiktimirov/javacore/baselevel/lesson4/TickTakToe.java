package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

public class TickTakToe {
}


class TickTakToeCell extends Cell {


    /**
     * Символьное обозначение значение ячейки:
     * 0, ячейка пустая - '•'
     * 1, в ячейке нолик - '0'
     * 2, в ячейке крестик - 'X'
     */
    char[] charList = {'•', '0', 'X'};

    /**
     * Главный конструктор
     *
     * @param field Ссылка на поле в котором находится ячейка
     * @param x     Координата по оси x
     * @param y     Координата по оси y
     */
    public TickTakToeCell(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    void paint() {

    }
}

class TickTakToeField extends Field {

    public TickTakToeField(int width, int height) {
        super(width, height);
    }

    public TickTakToeField(int size) {
        super(size);
    }

    @Override
    void createField() {
        cellList = new Cell[width][height];
        for (int i = 0; i < cellList.length; i++) {
            for (int j = 0; j < cellList.length; j++) {
                cellList[i][j] = new TickTakToeCell(this, j, i);
            }
        }
    }

    @Override
    void paintField() {

    }
}