package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task7 {
    /*
    * **** Написать метод, которому на вход подается одномерный массив
    * и число n (может быть положительным, или отрицательным),
    * при этом метод должен сместить все элементымассива на n позиций.
    * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int shift = -1;
        printTaskNumber(7);
        printMsg("Проверка сдвига массива на " + shift);
        printBeforeMsg(arr);

        shiftArray(arr, shift);

        printAfterMsg(arr);
        printNextTaskLine();

        arr = new int[]{1, 2, 3, 4, 5};
        shift = 1;

        printMsg("Проверка сдвига массива на " + shift);
        printBeforeMsg(arr);

        shiftArray(arr, shift);

        printAfterMsg(arr);
        printNextTaskLine();

        arr = new int[]{1, 2, 3, 4, 5};
        shift = -2;

        printMsg("Проверка сдвига массива на " + shift);
        printBeforeMsg(arr);

        shiftArray(arr, shift);

        printAfterMsg(arr);
        printNextTaskLine();

        arr = new int[]{1, 2, 3, 4, 5};
        shift = 4;

        printMsg("Проверка сдвига массива на " + shift);
        printBeforeMsg(arr);

        shiftArray(arr, shift);

        printAfterMsg(arr);
        printNextTaskLine();

        arr = new int[]{1, 2, 3, 4, 5};
        shift = 2000888888;

        printMsg("Проверка сдвига массива на " + shift);
        printBeforeMsg(arr);

        shiftArray(arr, shift);

        printAfterMsg(arr);
        printNextTaskLine();
    }

    /* Сдвиг массива на n элементов, -n в левую сторону, n в правую.
     * */
    public static int[] shiftArray(int[] arr, int shift){

        if (Math.abs(shift) == arr.length) return arr;

        // Максимальный индекс массива
        int maxIdx = arr.length - 1;

        for (int j = 0; j < Math.abs(shift % arr.length); j++){
            int i = 0;
            int cur = 0;
            int next = 1;

            if (shift < 0){
                cur = maxIdx;
                next = cur - 1;
            }

            do {
                if (shift < 0){
                    if (cur == 0){
                        next = maxIdx;
                    }
                    swapIndexes(arr, cur, next);
                    --cur;
                    --next;
                } else {
                    swapIndexes(arr, cur, next);
                    ++cur;
                    ++next;
                }

                i++;
            } while (i < maxIdx);
        }

        return arr;
    }

    // Рокировка двух элементов массива по их индексу.
    public static void swapIndexes(int[] arr, int from, int to){
        int val = arr[to];
        arr[to] = arr[from];
        arr[from] = val;
    }
}
