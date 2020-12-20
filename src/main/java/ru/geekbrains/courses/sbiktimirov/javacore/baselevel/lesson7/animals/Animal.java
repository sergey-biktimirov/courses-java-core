package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson7.animals;

/**
 * Животнок
 */
public abstract class Animal {

    private final String name;
    private final String color;

    /**
     * Уровень сытности, минимальное значение 0
     */
    private int satietyLevel = 0;

    /**
     * Максимальный уровень сытности,
     * По умолчанию 100
     */
    protected int MAX_SATIETY_LEVEL = 100;

    /**
     * Максимальная дистанция для бега,
     * По умолчанию 0
     */
    protected double MAX_RUN_DISTANCE = 0;
    /**
     * Максимальная дистанция для плавания,
     * По умолчанию 0
     */
    protected double MAX_SWIM_DISTANCE = 0;
    /**
     * Максимальная дистанция для прыжков,
     * По умолчанию 0
     */
    protected double MAX_JUMP_DISTANCE = 0;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Сыто ли животное
     *
     * @return boolean - true - сыто, false - проголодалось
     */
    public boolean isSatiety() {
        return satietyLevel == MAX_SATIETY_LEVEL;
    }

    /**
     * Уровень сытности
     *
     * @return int
     */
    public int getSatietyLevel() {
        return satietyLevel;
    }

    /**
     * Сколько надо еды до максимального уровня сытности
     *
     * @return int - Количество еды
     */
    public int needFood() {
        return (MAX_SATIETY_LEVEL - satietyLevel);
    }

    /**
     * Кушать
     *
     * @param value int - количество пищи
     * @return int - Уровень сытности после еды
     */
    protected int eat(int value) {
        return satietyLevel += Math.min(value, needFood());
    }

    /**
     * Изменить уровень сытности, сколько животное может съесть
     * Минимальное значение 0, максимальное значение 100
     *
     * @param satietyLevel - уровень сытности
     * @see Animal MAX_SATIETY_LEVEL
     */
    protected void changeSatietyLevel(int satietyLevel) {
        this.satietyLevel = Math.max(satietyLevel, 0);
    }

    /**
     * Бег
     *
     * @param v - дистанция бега
     *          По умолчанию 0
     * @see Animal MAX_RUN_DISTANCE
     */
    public abstract boolean run(double v);

    /**
     * Плавание
     * По умолчанию 0
     *
     * @param v - дистанция заплыва
     * @see Animal MAX_SWIM_DISTANCE
     */
    public abstract boolean swim(double v);

    /**
     * Прыжок
     * По умолчанию 0
     *
     * @param v - длина прыжка
     * @see Animal MAX_JUMP_DISTANCE
     */
    public abstract boolean jump(double v);

    /**
     * Имя
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Цвет животного
     *
     * @return String
     */
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("name: %s, color: %s, satietyLevel: %s, isSatiety: %b, " +
                        "MAX_RUN_DISTANCE: %.2f, MAX_SWIM_DISTANCE: %.2f, MAX_JUMP_DISTANCE: %.2f, " +
                        "MAX_SATIETY_LEVEL: %s",
                name, color, satietyLevel, isSatiety(),
                MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE, MAX_JUMP_DISTANCE,
                MAX_SATIETY_LEVEL);
    }
}
