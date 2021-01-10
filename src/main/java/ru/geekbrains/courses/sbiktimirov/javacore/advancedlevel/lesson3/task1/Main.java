package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson3.task1;

import java.util.HashMap;

/*
1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.
* */
public class Main {

    public static void main(String[] args) {

        /*Список слов и количества их повторений в массиве*/
        HashMap<String, Integer> wordsHashMap = new HashMap<>();

        /*Массив слов*/
        String[] words = new String[]{
                "назначение", "человечество", "актер", "актер", "водитель",
                "значение", "многое", "работа", "предприятие", "середина",
                "значение", "разрешение", "руководитель", "предприятие", "губернатор",
                "ситуация", "разрешение", "столица", "предприятие", "губернатор"
        };

        /*Заполнение списка и подсчет повторений*/
        for (String word : words) {
            int count = wordsHashMap.computeIfAbsent(word, cnt -> 0);
            wordsHashMap.put(word, ++count);
        }

        System.out.println();
        System.out.println("Вывод в консоль уникальных слов");
        System.out.println("-----------------------------------------------------------------------------------------");

        /*Вывод в консоль уникальных слов*/
        wordsHashMap.forEach((word, cnt) -> {
            if (cnt == 1) {
                System.out.printf("\"%s\"%n", word);
            }
        });

        System.out.println();
        System.out.println("Вывод в консоль повторяющихся слов, с количеством их повторений");
        System.out.println("-----------------------------------------------------------------------------------------");

        /*Вывод в консоль повторяющихся слов, с количеством их повторений*/
        wordsHashMap.forEach((word, cnt) -> {
            if (cnt > 1) {
                System.out.printf("Слово \"%s\" повторяется %s раз%n", word, cnt);
            }
        });

    }
}
