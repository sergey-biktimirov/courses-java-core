package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error;

public class ExceptionToManyPlayers extends Exception {
    public ExceptionToManyPlayers(String s) {
        super(s);
    }
}
