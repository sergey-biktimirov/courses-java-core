package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import java.util.Arrays;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task1 {
    /*
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0.
     * */
    public static void main(String[] args) {
        printTaskNumber(1);

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        printMsg("Задать целочисленный массив, состоящий из элементов 0 и 1.\n" +
                "Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]\n" +
                "С помощью цикла и условия заменить 0 на 1, 1 на 0.");
        printMsg("Результат:");
        printBeforeMsg(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }

        printAfterMsg(arr);
        printNextTaskLine();
    }
}
