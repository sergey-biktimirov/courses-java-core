package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6.animals;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

/*
 У каждого животного есть ограничения
 на действия (бег: кот 200 м., собака 500 м.;
              прыжок: кот 2 м., собака 0.5 м.;
              плавание: кот не умеет плавать, собака 10 м.).
 Добавить животным разброс в ограничениях.
 То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
* */
public class Dog extends Animal {

    public Dog(String name, String color) {
        super(name, color);
        MAX_RUN_DISTANCE = nextRandomDouble(400, 600);
        MAX_JUMP_DISTANCE = nextRandomDouble(0.1, 1);
        MAX_SWIM_DISTANCE = nextRandomDouble(9, 11);
    }

    @Override
    public boolean run(double v) {
        return v > 0 && v <= MAX_RUN_DISTANCE;
    }

    @Override
    public boolean swim(double v) {
        return v > 0 && v <= MAX_SWIM_DISTANCE;
    }

    @Override
    public boolean jump(double v) {
        return v > 0 && v <= MAX_JUMP_DISTANCE;
    }

    @Override
    public String toString() {
        return String.format("Dog {%s}", super.toString());
    }
}
