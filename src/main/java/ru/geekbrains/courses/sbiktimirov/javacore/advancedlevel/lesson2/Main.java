package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson2;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson2.exception.MyArrayDataException;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson2.exception.MyArraySizeException;

import static ru.geekbrains.courses.sbiktimirov.utl.ArrayUtl.arrAsString;

/*
1. Напишите метод,
 на вход которого подается двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException – с детализацией,
 в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод,
 обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
* */
public class Main {

    public static void main(String[] args) {

        /*Проверка на размер массива 1x4*/
        try {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Проверка на размер массива 1x4");

            Thread.sleep(50);

            String[][] arr = new String[1][4];

            sumArrayValues(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Проверка на размер массива 3x3*/
        try {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Проверка на размер массива 3x3");

            Thread.sleep(50);

            String[][] arr = new String[3][3];

            sumArrayValues(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Проверка на размер массива 4x1*/
        try {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Проверка на размер массива 4x1");

            Thread.sleep(50);

            String[][] arr = new String[4][1];

            sumArrayValues(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Проверка суммирования массива 4x4 со строковым элементом в массиве по индексу [1][3]*/
        try {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Проверка суммирования массива 4x4 со строковым элементом в массиве по индексу [1][3]");

            Thread.sleep(50);

            String[][] arr = new String[][]{
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "d"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
            };

            sumArrayValues(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Проверка суммирования массива 4x4*/
        try {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Проверка суммирования массива 4x4");

            String[][] arr = new String[][]{
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
            };

            System.out.println(arrAsString(arr));

            Thread.sleep(50);

            System.out.printf("Сумма массива %s = %s", arrAsString(arr), sumArrayValues(arr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int sumArrayValues(String[][] arr) throws Exception {
        int sum = 0;

        {
            int i = arr.length;
            int j = arr.length > 0 ? arr[0].length : 0;
            if (i != 4 || j != 4) {
                throw new MyArraySizeException(String.format("Допустимы размер массива 4x4, текущий %sx%s", i, j));
            }
        }

        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    String value = arr[i][j];
                    try {
                        sum += Integer.parseInt(value);
                    } catch (Exception e) {
                        throw new MyArrayDataException(i, j, value, "Ошибка суммирования массива", e);
                    }
                }
            }
        } catch (MyArrayDataException e) {
            throw new Exception(String.format("Индекс [%s][%s] значение %s, Ошибка суммирования массива",
                    e.getI(), e.getJ(), e.getValue()), e
            );
        }

        return sum;
    }
}
