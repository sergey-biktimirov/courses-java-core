package ru.geekbrains.courses.sbiktimirov.utl;

import java.util.HashMap;

public class Utl {

    /**
     * Генератор дробного числа
     *
     * @param min double - Минимальное значение
     * @param max double - Максимальное значение
     * @return double
     */
    public static double nextRandomDouble(int min, int max) {
        return Math.random() * (max + 1 - (min)) + (min);
    }

    /**
     * Генератор дробного числа
     *
     * @param min double - Минимальное значение
     * @param max double - Максимальное значение
     * @return double
     */
    public static double nextRandomDouble(double min, double max) {
        return Math.random() * (max + 1 - (min)) + (min);
    }
}
