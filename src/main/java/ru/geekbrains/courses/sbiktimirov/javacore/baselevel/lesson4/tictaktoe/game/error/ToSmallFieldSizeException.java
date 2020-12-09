package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class ToSmallFieldSizeException extends Exception {
    public ToSmallFieldSizeException(String s) {
        super(s);
    }
}