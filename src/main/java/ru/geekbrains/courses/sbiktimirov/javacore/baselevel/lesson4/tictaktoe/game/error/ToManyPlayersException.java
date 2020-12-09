package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class ToManyPlayersException extends Exception {
    public ToManyPlayersException(String s) {
        super(s);
    }
}
