package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.being.action;

public interface Run {

    /**
     * Бег
     *
     * @param val дистанция
     * @return boolean - дистанция true - преодолена, false - не преодолена
     */
    boolean run(double val);

    /**
     * Установить максимальное значение преодоления препятствия
     */
    Run setMaxRunValue(double val);

    /**
     * Получить максимальное значение преодоления препятствия
     */
    double getMaxRunValue();
}
