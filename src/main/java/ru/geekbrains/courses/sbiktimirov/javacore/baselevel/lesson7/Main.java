package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals.Cat;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals.Plate;

import java.util.Arrays;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.nextRandomInt;

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой
 не могло получиться отрицательного количества еды
 (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость
 (когда создаем котов, они голодны).
 Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке,
 то он ее просто не трогает,
 то есть не может быть наполовину сыт
 (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой,
 попросить всех котов покушать из этой тарелки
 и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод,
 с помощью которого можно было бы добавлять еду в тарелку
* */
public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Cat 1", "color 1", nextRandomInt(80, 95)),
                new Cat("Cat 2", "color 2", nextRandomInt(80, 95)),
                new Cat("Cat 3", "color 3", nextRandomInt(80, 95)),
                new Cat("Cat 4", "color 4", nextRandomInt(80, 95))
        };

        Plate plate = new Plate(20);

        System.out.println("Остаток в тарелке = " + plate.getValue());
        System.out.printf("Получение %s единиц еды%n", 200);
        plate.takeFood(200);

        System.out.println("Остаток в тарелке = " + plate.getValue());
        System.out.printf("Добавление %s единиц еды%n", 20);
        plate.addFood(20);

        Arrays.asList(cats).forEach(cat -> {
            System.out.println("Остаток в тарелке = " + plate.getValue());
            System.out.printf("%s проголодался, ему требуется %s еды%n", cat.getName(), cat.needFood());
            System.out.printf("%s %sпоел%n", cat.getName(), cat.eat(plate) ? "" : "не ");
        });

        System.out.println();
        Arrays.asList(cats).forEach(System.out::println);
    }
}
