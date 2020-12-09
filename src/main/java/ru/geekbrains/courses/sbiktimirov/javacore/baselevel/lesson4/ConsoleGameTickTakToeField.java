package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Cell;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Field;

public class ConsoleGameTickTakToeField extends Field {

    private int colWidth = 0;
    private int rowHeight = 0;

    public ConsoleGameTickTakToeField() {
        super(3);
        createField();
    }

    public ConsoleGameTickTakToeField(int width, int height) {
        super(width, height);
        createField();
    }

    public ConsoleGameTickTakToeField(int size) {
        super(size);
        createField();
    }

    @Override
    public void createField() {
        cellList = new ConsoleGameTickTakToeCell[width][height];
        colWidth = String.valueOf(width).length();
        rowHeight = String.valueOf(height).length();
        for (int i = 0; i < cellList.length; i++) {
            for (int j = 0; j < cellList.length; j++) {
                cellList[i][j] = new ConsoleGameTickTakToeCell(this, j, i);
            }
        }
    }

    @Override
    public void paintField() {
        printHead();
        System.out.println();
        printRows();
    }

    private void printHead() {
        String fmt = "%" + colWidth + "s | ";
        System.out.printf(fmt, "");
        for (int i = 0; i < width; i++) {
            System.out.printf(fmt, i + 1);
        }
    }

    private void printRows() {
        String fmt = "%" + colWidth + "s | ";
        for (int j = 0; j < height; j++){
            System.out.printf(fmt, j + 1);
            for (int i = 0; i < width; i++){
                System.out.printf(fmt, ((ConsoleGameTickTakToeCell)cellList[j][i]).getChar());
            }
            System.out.println();
        }
    }
}