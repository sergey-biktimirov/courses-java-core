package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson6.animals;

/* Животные могут выполнять действия:
   бежать,
   плыть,
   перепрыгивать препятствие.
   В качестве параметра каждому методу передается величина,
   означающая или длину препятствия (для бега и плавания),
   или высоту (для прыжков).
*/
public abstract class Animal {

    private final String name;
    private final String color;

    protected double MAX_RUN_DISTANCE;
    protected double MAX_SWIM_DISTANCE;
    protected double MAX_JUMP_DISTANCE;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public abstract boolean run(double v);

    public abstract boolean swim(double v);

    public abstract boolean jump(double v);


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("name: %s, color: %s, " +
                        "MAX_RUN_DISTANCE: %.2f, MAX_SWIM_DISTANCE: %.2f, MAX_JUMP_DISTANCE: %.2f",
                name,
                color,
                MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE, MAX_JUMP_DISTANCE);
    }
}
