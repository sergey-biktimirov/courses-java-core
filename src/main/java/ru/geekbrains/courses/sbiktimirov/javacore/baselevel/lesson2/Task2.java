package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task2 {
    /*
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
     * */
    public static void main(String[] args) {
        printTaskNumber(2);
        printMsg("Задать пустой целочисленный массив размером 8.\n" +
                "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.");

        int[] arr = new int[8];

        printMsg("Результат:");
        printBeforeMsg(arr);

        for (int i = 0, n = 0; i < arr.length; i++, n += 3) {
            arr[i] = n;
        }

        printAfterMsg(arr);
        printNextTaskLine();
    }
}
