package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.being.human;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.being.action.Jump;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.being.action.Run;

/**
 * Человек
 */
public class Human implements Jump, Run {

    private String name;
    private int age;
    private double growth;
    private double weight;
    private final Gender gender;

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

    public Human(String name, int age, double growth, double weight, Gender gender) {
        setName(name);
        setAge(age);
        setGrowth(growth);
        setWeight(weight);
        this.gender = gender;
    }

    /**
     * Бег
     *
     * @param v - дистанция бега
     *          По умолчанию 0
     */
    @Override
    public boolean run(double v) {
        return v > 0 && v <= getMaxRunValue();
    }

    /**
     * Прыжок
     * По умолчанию 0
     *
     * @param v - длина или высота прыжка
     */
    @Override
    public boolean jump(double v) {
        return v > 0 && v <= getMaxJumpValue();
    }

    public String getName() {
        return name;
    }

    public Human setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Human setAge(int age) {
        this.age = age;
        return this;
    }

    public double getGrowth() {
        return growth;
    }

    public Human setGrowth(double growth) {
        this.growth = growth;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Human setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public double getMaxRunValue() {
        return maxRunValue;
    }

    public Human setMaxRunValue(double value) {
        this.maxRunValue = value >= 0 ? value : 0;
        return this;
    }

    public double getMaxJumpValue() {
        return maxJumpValue;
    }

    public Human setMaxJumpValue(double value) {
        this.maxJumpValue = value >= 0 ? value : 0;
        return this;
    }
}
