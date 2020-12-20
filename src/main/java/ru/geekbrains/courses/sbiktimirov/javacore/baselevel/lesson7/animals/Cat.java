package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals.Animal;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals.Plate;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

public class Cat extends Animal {

    public Cat(String name, String color) {
        super(name, color);
        MAX_RUN_DISTANCE = nextRandomDouble(100, 300);
        MAX_JUMP_DISTANCE = nextRandomDouble(1, 3);
        MAX_SWIM_DISTANCE = 0;
    }

    public Cat(String name, String color, int satietyLevel) {
        super(name, color);
        MAX_RUN_DISTANCE = nextRandomDouble(100, 300);
        MAX_JUMP_DISTANCE = nextRandomDouble(1, 3);
        MAX_SWIM_DISTANCE = 0;
        super.changeSatietyLevel(satietyLevel);
    }

    /**
     * Бег
     */
    @Override
    public boolean run(double v) {
        return v > 0 && v <= MAX_RUN_DISTANCE;
    }

    @Override
    public boolean swim(double v) {
        return false;
    }

    @Override
    public boolean jump(double v) {
        return v > 0 && v <= MAX_JUMP_DISTANCE;
    }

    public boolean eat(Plate plate) {
        super.eat(plate.getValue() >= needFood() ? plate.takeFood(needFood()) : 0);
        return isSatiety();
    }

    @Override
    public String toString() {
        return "Cat {" + super.toString() + "}";
    }
}
