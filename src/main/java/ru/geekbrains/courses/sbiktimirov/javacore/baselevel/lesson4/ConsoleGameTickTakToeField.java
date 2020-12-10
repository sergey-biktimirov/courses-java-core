package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Field;

public class ConsoleGameTickTakToeField extends Field {

    private int colWidth = 0;
    private int rowHeight = 0;

    public ConsoleGameTickTakToeField(int size) {
        super(size);
        createField();
    }

    @Override
    public void createField() {
        cellList = new ConsoleGameTickTakToeCell[height][width];
        colWidth = String.valueOf(width).length();
        rowHeight = String.valueOf(height).length();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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
        System.out.printf( "%" + rowHeight + "s | ", "");
        for (int i = 0; i < width; i++) {
            System.out.printf("%" + colWidth + "s | ", i + 1);
        }
    }

    private void printRows() {
        String fmt = "%" + rowHeight + "s | ";
        for (int j = 0; j < height; j++){
            System.out.printf(fmt, j + 1);
            for (int i = 0; i < width; i++){
                System.out.printf("%" + colWidth + "s | ", ((ConsoleGameTickTakToeCell)cellList[j][i]).getChar());
            }
            System.out.println();
        }
    }
}