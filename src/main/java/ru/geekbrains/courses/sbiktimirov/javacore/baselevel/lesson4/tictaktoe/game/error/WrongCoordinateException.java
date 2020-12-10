package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class WrongCoordinateException extends Exception {
    public WrongCoordinateException(String s) {
        super(s);
    }
}
