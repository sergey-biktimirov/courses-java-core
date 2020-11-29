package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task4 {
    /*
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
     * */
    public static void main(String[] args) {
        printTaskNumber(4);
        printMsg("Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),\n" +
                "и с помощью цикла(-ов) заполнить его диагональные элементы единицами.");

        int squareSize = 7;

        int[][] arr = new int[squareSize][squareSize];

        printMsg("Результат:");
        printBeforeMsg(arr);

        for (int i = 0; i < squareSize; i++) {
            arr[i][i] = 1;
            arr[squareSize - 1 - i][i] = 1;
        }


        printAfterMsg(arr);
        printNextTaskLine();
    }
}
