package ru.geekbrains.courses.sbiktimirov.utl;

public class Utl {

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
        return (int) (Math.random() * (max + 1 - (min)) + (min));
    }

    /**
     * Генератор номера телефона
     *
     * @return String - +7(950)-447-53-990
     */
    public static String getRandomPhoneNumber() {
        return String.format("+7(%3s)-%3s-%2s-%3s",
                substrRight(getRandomNumber(1950, 1960), 3),
                substrRight(getRandomNumber(1000, 1999), 3),
                substrRight(getRandomNumber(100, 199), 2),
                substrRight(getRandomNumber(1000, 1999), 3)
        );
    }

    /**
     * Генератор целого числа
     *
     * @param min int - Минимальное значение
     * @param max int - Максимальное значение
     * @return String
     */
    public static String getRandomNumber(int min, int max) {
        return String.valueOf(nextRandomInt(min, max));
    }

    /**
     * Обрезает строку справа на указанную длину
     *
     * @param s   String - Входящая строка
     * @param len int - Количество символов от конца строки
     * @return String
     */
    public static String substrRight(String s, int len) {
        return s.substring(s.length() - len);

    }

    /**
     * Обрезает строку слева на указанную длину
     *
     * @param s   String - Входящая строка
     * @param len int - Количество символов от начала строки
     * @return String
     */
    public static String substrLeft(String s, int len) {
        return s.substring(0, len);
    }
}
