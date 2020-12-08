package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Cell;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.Field;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToManyPlayers;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson4.tictaktoe.game.error.ExceptionToSmallFieldSize;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConsoleGameTicTakToe game = new ConsoleGameTicTakToe(System.in);
    }
}

