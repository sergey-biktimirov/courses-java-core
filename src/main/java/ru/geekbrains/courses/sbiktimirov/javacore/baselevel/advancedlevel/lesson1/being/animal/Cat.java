package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.animal;

public class Cat extends Animal {

    public Cat(String name, String color) {
        super(name, color);
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

    @Override
    public String toString() {
        return "Cat {" + super.toString() + "}";
    }
}
