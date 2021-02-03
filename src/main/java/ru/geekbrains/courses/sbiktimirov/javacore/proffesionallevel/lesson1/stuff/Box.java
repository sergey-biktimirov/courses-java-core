package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1.stuff;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson1.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();
    private int fruitCount = 0;
    private double weight = 0d;

    public double getWeight() {
        return weight;
    }

    public <F extends T> void addFruit(F... fruit) {
        for(T f : fruit) {
            ++fruitCount;
            weight += f.getWeight();
            fruits.add(f);
        }
    }

    /*4. Сделать метод getWeight(), который высчитывает вес коробки,
     зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);*/
    public double getWight() {
        return weight;
    }

    /*5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
     которую подадут в compare() в качестве параметра.
     true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;*/
    public boolean compare(Box<Fruit> box) {
        return this.weight == box.weight;
    }

    /*6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;*/
    public <F extends T> void pourOver(Box<F> box) {
        this.fruits.addAll(box.fruits);
        box.fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }
}
