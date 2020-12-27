package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport;

/**
 * Абстрактное препятствие
 */
public abstract class Hurdle {
    /**
     * Определение
     */
    private String definition;
    /**
     * Значение
     */
    private double value;

    /**
     * Конструктор
     */
    public Hurdle(String definition, double value) {
        setDefinition(definition);
        setValue(value);
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "definition='" + definition + '\'' +
                ", value=" + value
                ;
    }
}
