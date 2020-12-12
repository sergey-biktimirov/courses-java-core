package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6.animals.Animal;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6.animals.Cat;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6.animals.Dog;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.nextRandomDouble;

/* 1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия:
 бежать, плыть, перепрыгивать препятствие.
 В качестве параметра каждому методу передается величина,
 означающая или длину препятствия (для бега и плавания),
 или высоту (для прыжков).
3. У каждого животного есть ограничения
 на действия (бег: кот 200 м., собака 500 м.;
              прыжок: кот 2 м., собака 0.5 м.;
              плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий,
 оно должно сообщить результат в консоль.
 (Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях.
 То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
* */
public class Main {
    public static void main(String[] args) {

        Animal[] animals = {
                new Dog("Dog 1", "color 1"),
                new Dog("Dog 2", "color 2"),
                new Dog("Dog 3", "color 3"),
                new Dog("Dog 4", "color 4"),

                new Cat("Cat 1", "color 1"),
                new Cat("Cat 2", "color 2"),
                new Cat("Cat 3", "color 3"),
                new Cat("Cat 4", "color 4")
        };

        for (Animal animal : animals) {
            double run = nextRandomDouble(100, 600);
            double swim = nextRandomDouble(0, 10);
            double jump = nextRandomDouble(0.1, 3);
            System.out.printf("%s -> run(%.2f): %b, swim(%.2f): %b, jump(%.2f): %b%n",
                    animal,
                    run,
                    animal.run(run),
                    swim,
                    animal.swim(swim),
                    jump,
                    animal.jump(jump)
            );
        }
    }
}
