package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson2.exception;

public class MyArrayDataException extends Exception {

    private final int i;
    private final int j;
    private final String value;

    public MyArrayDataException(int i, int j, String value, String message) {
        super(message);
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public MyArrayDataException(int i, int j, String value, String message, Throwable cause) {
        super(message, cause);
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getValue() {
        return value;
    }
}
