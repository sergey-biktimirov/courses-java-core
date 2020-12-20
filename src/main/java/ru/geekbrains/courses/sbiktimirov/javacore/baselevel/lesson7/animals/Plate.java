package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals;

public class Plate {

    /**
     * Количество еды в тарелке
     */
    private int value;

    public Plate(int value) {
        this.value = value;
    }

    /**
     * Добавить еду в тарелку
     *
     * @param value int - добавляемое количество еды
     */
    public void addFood(int value) {
        this.value += value;
    }

    /**
     * Взять еды из тарелки
     *
     * @param value int - Запрашиваемое количество еды
     * @return int - Фактическое, полученное количество еды
     */
    public int takeFood(int value) {
        int val = 0;
        if (this.value < value) {
            val = this.value;
            this.value = 0;
        } else {
            val = value;
            this.value -= value;
        }
        return val;
    }

    /**
     * Остаток еды в тарелку
     *
     * @return int
     */
    public int getValue() {
        return value;
    }
}
