package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.human;

/**
 * Пол
 */
public enum Gender {
    MALE("мужской"), FEMALE("женский");

    private final String description;

    public String getDescription() {
        return description;
    }

    Gender(String description) {
        this.description = description;
    }
}
