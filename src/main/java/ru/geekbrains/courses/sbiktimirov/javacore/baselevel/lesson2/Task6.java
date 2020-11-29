package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Task6 {
    /*
     * ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место,
     * в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     * checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
     * эти символы в массив не входят.
     * */
    public static void main(String[] args) {
        printTaskNumber(6);
        printMsg("Проверка сбалансированности чисел в массиве.\n" +
                "true - массив сбалансированный\n" +
                "false - нет");
        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};

        printMsg("Проверка массива:", arr);
        printMsg("Результат: true");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[]{1};
        printMsg("Проверка массива:", arr);
        printMsg("Результат: false");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[]{1, 2};
        printMsg("Проверка массива:", arr);
        printMsg("Результат: false");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[0];
        printMsg("Проверка массива:", arr);
        printMsg("Результат: false");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[]{2, 1, 1};
        printMsg("Проверка массива:", arr);
        printMsg("Результат: true");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[]{1, 0, 1, 0, 1, -1};
        printMsg("Проверка массива:", arr);
        printMsg("Результат: true");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();

        arr = new int[]{1, 0, 1, 0, 2, -1};
        printMsg("Проверка массива:", arr);
        printMsg("Результат: false");
        System.out.println(checkNumArrBalance(arr));
        printNextTaskLine();
    }

    /* Проверка сбалансированности чисел в массиве.
     * Массив считается сбалансированным (возвращает true),
     * если сумма левых чисел равна сумме правых,
     * иначе массив не сбалансированный (возвращает false).
     * */
    public static boolean checkNumArrBalance(int[] arr) {
        // Если длина массива меньше двух, тогда нечего сравнивать,
        // а значит массив не сбалансированный.
        if (arr.length < 2) {
            return false;
            // Если длина массива равна  двум, тогда
            // выполняется проверка двух элементов массива, на равенство.
        } else if (arr.length == 2) {
            return arr[0] == arr[1];
        }

        // Присвоение стартового значения левого индекса.
        int lIdx = 0;
        // Присвоение стартового значения правого индекса,
        // равного индексу последнего элемента массива.
        int rIdx = arr.length - 1;

        // Инициализация суммы левых значений.
        int lSum = arr[lIdx];
        // Инициализация суммы правых значений.
        int rSum = arr[rIdx];

        do {
            if (lSum < rSum) {
                lSum += arr[++lIdx];
            } else if (rSum < lSum || lSum == rSum) {
                rSum += arr[--rIdx];
            }
        } while (Math.abs(lIdx - rIdx) != 1);

        return lSum == rSum;
    }
}
