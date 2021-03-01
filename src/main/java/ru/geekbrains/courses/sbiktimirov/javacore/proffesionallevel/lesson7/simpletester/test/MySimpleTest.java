package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.test;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.AfterSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.BeforeSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.Test;

public class MySimpleTest {

    @BeforeSuite()
    public void testBeforeSuite() {

    }

    @AfterSuite()
    public void testAfterSuite() {

    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("test 1 priority 1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("test 2 priority 2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("test 3 priority 1");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("test 4 priority 3");
    }

    @Test(priority = 4)
    public void test5() {
        System.out.println("test 5 priority 4");
    }


}
