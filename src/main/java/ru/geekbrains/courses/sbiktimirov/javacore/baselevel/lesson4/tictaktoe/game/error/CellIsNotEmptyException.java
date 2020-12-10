package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class CellIsNotEmptyException extends Exception {
    public CellIsNotEmptyException(String s) {
        super(s);
    }
}
