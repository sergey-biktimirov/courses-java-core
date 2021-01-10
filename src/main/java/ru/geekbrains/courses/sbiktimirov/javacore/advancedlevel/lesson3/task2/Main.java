package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson3.task2;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.nextRandomInt;
import static ru.geekbrains.courses.sbiktimirov.utl.Utl.getRandomPhoneNumber;

/*
1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.
* */
public class Main {

    public static void main(String[] args) {
        String[] surnames = new String[] {
                "Меркушев",
                "Лебедев",
                "Комаров",
                "Зуев",
                "Васильев",
                "Устинов",
                "Никонов",
        };

        PhoneBook phoneBook = new PhoneBook();

        for (int i = 0; i <= 14; i++) {
            phoneBook.add(surnames[nextRandomInt(0, surnames.length - 1)], getRandomPhoneNumber());
        }

        System.out.println();
        System.out.println(phoneBook.getAll());
        System.out.println();

        for (String surname : surnames) {
            System.out.printf("%s, номера телефонов: %n  %s%n", surname, phoneBook.get(surname));
        }

    }
}
