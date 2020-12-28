package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.thing.robot;

/**
 * Робот
 */
public abstract class Robot {

    private String name;
    private final String model;

    public Robot(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public Robot setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }
}
