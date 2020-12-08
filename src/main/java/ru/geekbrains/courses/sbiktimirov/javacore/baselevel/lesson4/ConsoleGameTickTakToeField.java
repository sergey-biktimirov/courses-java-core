package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Cell;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Field;

public class ConsoleGameTickTakToeField extends Field {
    public ConsoleGameTickTakToeField(int width, int height) {
        super(width, height);
    }

    public ConsoleGameTickTakToeField(int size) {
        super(size);
    }

    @Override
    public void createField() {
        cellList = new Cell[width][height];
        for (int i = 0; i < cellList.length; i++) {
            for (int j = 0; j < cellList.length; j++) {
                cellList[i][j] = new ConsoleGameTickTakToeCell(this, j, i);
            }
        }
    }

    @Override
    public void paintField() {

    }
}