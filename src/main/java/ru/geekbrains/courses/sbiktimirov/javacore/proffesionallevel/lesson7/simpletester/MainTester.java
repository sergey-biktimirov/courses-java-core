package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.engine.SimpleTesterEngine;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.test.MySimpleTest;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.test.MySimpleTestCrashedAfterSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.test.MySimpleTestCrashedBeforeSuite;

public class MainTester {

    public static void main(String[] args) {
        try {
            SimpleTesterEngine.start(MySimpleTestCrashedBeforeSuite.class);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            SimpleTesterEngine.start(MySimpleTestCrashedAfterSuite.class);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        SimpleTesterEngine.start(MySimpleTest.class);
    }
}
