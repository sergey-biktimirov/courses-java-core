package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task5 {
    /*
     * ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета).
     * */
    public static void main(String[] args) {
        printTaskNumber(5);

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printMsg("Задать одномерный массив и найти в нем минимальный\n" +
                "и максимальный элементы (без помощи интернета).");
        printMsg("Поиск минимального и максимального значений в массиве:\n", arr);

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int value : arr) {
            minVal = Math.min(minVal, value);
            maxVal = Math.max(maxVal, value);
        }
        printMsg("Результат:");
        System.out.println(
                " Минимальное значение: " + minVal + "\n" +
                        "Максимальное значение: " + maxVal);
        printNextTaskLine();
    }
}
