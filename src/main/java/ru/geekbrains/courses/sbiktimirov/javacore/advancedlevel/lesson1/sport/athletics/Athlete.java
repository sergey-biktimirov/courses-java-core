package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.athletics;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Hurdle;

/**
 * Спортивные качества
 */
public interface Athlete {

    /**
     * Преодоление препятствий
     *
     * @param hurdle - препятствие
     * @return - true - преодолено, false - не преодолено
     */
    boolean makeHurdle(Hurdle hurdle);

    /**
     * Получить имя спортсмена
     */
    String getName();

    /**
     * Задать имя спортсмена
     *
     * @param name - имя спортсмена
     */
    Athlete setName(String name);
}
