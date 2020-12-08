package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Cell;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Field;

class ConsoleGameTickTakToeCell extends Cell {

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
    public ConsoleGameTickTakToeCell(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public void paint() {

    }
}
