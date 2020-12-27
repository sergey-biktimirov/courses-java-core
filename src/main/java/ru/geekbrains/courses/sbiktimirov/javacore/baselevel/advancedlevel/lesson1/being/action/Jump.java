package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.action;

public interface Jump {

    /**
     * Прыжок
     *
     * @param val длина прыжка
     * @return boolean - длина true - преодолена, false - не преодолена
     */
    boolean jump(double val);

    /**
     * Установить максимальное значение преодоления препятствия
     */
    Jump setMaxJumpValue(double val);

    /**
     * Получить максимальное значение преодоления препятствия
     */
    double getMaxJumpValue();
}
