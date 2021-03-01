package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.test;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.AfterSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.BeforeSuite;

public class MySimpleTestCrashedAfterSuite {

    @BeforeSuite()
    public void testBeforeSuite() {

    }

    @AfterSuite()
    public void testAfterSuite1(Object o) {

    }

    @AfterSuite()
    public void testAfterSuite2(Object o) {

    }


}
