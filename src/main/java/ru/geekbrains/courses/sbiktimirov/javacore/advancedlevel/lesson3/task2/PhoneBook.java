package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson3.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Телефонная книга
 */
public class PhoneBook {
    /**
     * Номера телефонов по фамильно
     */
    private final HashMap<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    /**
     * Добавление номера телефона по фамилии
     *
     * @param surname     Фамилия
     * @param phoneNumber Номер телефона
     */
    public void add(String surname, String phoneNumber) {
        Set<String> pnSet = getOrEmptySet(surname);

        pnSet.add(phoneNumber);
    }

    /**
     * Получение спика номеров телефонов по фамилии,
     * если по фамилии нет номеров телефонов, тогда возвращается пустой список
     * @param surname Фамилия
     * @return Список номеров телефонов по фамилии
     */
    private Set<String> getOrEmptySet(String surname) {
        return phoneBook.computeIfAbsent(surname, k -> new HashSet<>());
    }

    /**
     * Получение спика номеров телефонов по фамилии,
     * если по фамилии нет номеров телефонов, тогда возвращается пустой список.
     * @param surname Фамилия
     * @return Строку номеров телефонов по фамилии
     */
    public String get(String surname) {
        return getOrEmptySet(surname).toString();
    }


    /**
     * Получение спика номеров телефонов по фамилии,
     * если по фамилии нет номеров телефонов, тогда возвращается пустой список
     * @return Строку всех записей в телефонной книге
     */
    public String getAll() {
        return phoneBook.toString();
    }
}