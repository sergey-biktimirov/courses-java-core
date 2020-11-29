package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task3 {
    /*
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2.
     * */
    public static void main(String[] args) {
        printTaskNumber(3);
        printMsg("Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,\n" +
                "и числа меньшие 6 умножить на 2.");

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printMsg("Результат:");
        printBeforeMsg(arr);

        for (int i = 0; i < arr.length; i++) {
            int curNum = arr[i];
            // Перезапись элементов подходящих под условие.
            if (curNum < 6) arr[i] = curNum * 2;
//            arr[i] = curNum < 6 ? curNum * 2 : curNum;
        }

        printAfterMsg(arr);
        printNextTaskLine();
    }
}
