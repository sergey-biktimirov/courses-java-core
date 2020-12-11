package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson5;
/**
 * Сотрудник
 * */
public class Employee {
    /**
     * ФИО
     * */
    String fullName;
    /**
     * Должность
     * */
    String post;
    /**
     * email
     * */
    String email;
    /**
     * Телефон
     * */
    String phoneNumber;
    /**
     * Зарплата
     * */
    double salary;
    /**
     * Возраст
     * */
    int age;

    /**
     * Конструктор
     * */
    public Employee(String fullName, String post, String email, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s%n" +
                "Должность: %s%n" +
                "email: %s%n" +
                "Телефон: %s%n" +
                "Зарплата: %.2f%n" +
                "Возраст: %d%n",
                fullName,
                post,
                email,
                phoneNumber,
                salary,
                age);
    }

    public void printInConsole(){
        System.out.println(this);
    }
}
