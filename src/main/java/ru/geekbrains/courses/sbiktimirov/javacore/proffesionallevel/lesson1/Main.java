package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1.fruit.Apple;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1.fruit.Orange;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1.stuff.Box;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Main {

    public static void main(String[] args) throws Exception {

        /*1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);*/
        try {
            printTaskNumber(1);
            String[] arr = {"0", "1", "2"};
            printBeforeMsg(arr);
            swapElements(arr, 1, 2);
            printAfterMsg(arr);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        printNextTaskLine();
        /*2. Написать метод, который преобразует массив в ArrayList;*/
        {
            printTaskNumber(2);
            String[] arr = {"0", "1", "2"};
            printBeforeMsg(arr);
            toArrayList(arr);
            printAfterMsg(arr);
        }
        /*3. Задача:*/
        printTaskNumber(3);
        printMsg("Создание ящиков с апельсинами");
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 10; i++) orangeBox.addFruit(new Orange(Math.random() * i));
        printBeforeMsg(orangeBox.getFruits().toArray());

        printMsg("Создание ящиков с яблоками");
        Box<Apple> appleBox = new Box<>();

        for (int i = 0; i < 10; i++) appleBox.addFruit(new Apple(Math.random() * i));
        printBeforeMsg(appleBox.getFruits().toArray());

        printMsg("Создание пустого ящика");
        Box<Orange> orangeBox1 = new Box<>();
        printBeforeMsg(orangeBox1.getFruits().toArray());

        printMsg("Перекидывание апельсинов в пустой ящик");
        printBeforeMsg(orangeBox1.getFruits().toArray());
        orangeBox1.pourOver(orangeBox);
        printAfterMsg(orangeBox1.getFruits().toArray());

        //orangeBox.addFruit(new Apple(1d));

    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
     */
    static <T> T[] swapElements(T[] arr, int fromIndex, int toIndex) {
        T tmp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = tmp;
        //TODO No time for exception!
        return arr;
    }

    /**
     * 2. Написать метод, который преобразует массив в ArrayList;
     */
    static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
