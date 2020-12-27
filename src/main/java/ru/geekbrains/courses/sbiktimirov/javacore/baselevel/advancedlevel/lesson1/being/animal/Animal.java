package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.animal;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.action.Jump;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.action.Run;

/**
 * Животное
 */
public abstract class Animal implements Jump, Run {

    private String name;
    private String color;

    /**
     * Максимальная дистанция для бега,
     * По умолчанию 0
     */
    private double maxRunValue = 0;

    /**
     * Максимальная дистанция или высота для прыжка
     * По умолчанию 0
     */
    private double maxJumpValue = 0;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Бег
     *
     * @param v - дистанция бега
     *          По умолчанию 0
     */
    public abstract boolean run(double v);

    /**
     * Прыжок
     * По умолчанию 0
     *
     * @param v - длина или высота прыжка
     */
    public abstract boolean jump(double v);

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Animal setColor(String color) {
        this.color = color;
        return this;
    }

    public double getMaxRunValue() {
        return maxRunValue;
    }

    public Animal setMaxRunValue(double value) {
        this.maxRunValue = value >= 0 ? value : 0;
        return this;
    }

    public double getMaxJumpValue() {
        return maxJumpValue;
    }

    public Animal setMaxJumpValue(double value) {
        this.maxJumpValue = value >= 0 ? value : 0;
        return this;
    }
}
