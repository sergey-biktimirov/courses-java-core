package ru.geekbrains.courses.sbiktimirov.utl;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.HashMap;
import java.util.Random;

public class MathUtl {

    static RandomDataGenerator random = new RandomDataGenerator();

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
        return random.nextUniform(min, max);
    }

    /**
     * Генератор целого числа
     *
     * @param max int - Максимальное значение
     * @return int
     */
    public static int nextRandomInt(int max) {
        return (int) (Math.random() * (max + 1));
    }


    /**
     * Генератор целого числа
     *
     * @param min int - Минимальное значение
     * @param max int - Максимальное значение
     * @return int
     */
    public static int nextRandomInt(int min, int max) {
        return random.nextInt(min, max);
    }
}
