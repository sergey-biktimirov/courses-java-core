package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson5;

import static ru.geekbrains.courses.sbiktimirov.utl.Utl.*;

/*
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 * */
public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        for (int i = 0; i < employees.length; i++) {

            String fullName = getRandomFullName();
            String email = getEmail(fullName);
            String phoneNumber = getRandomPhoneNumber();

            double salary = getRandomSalary();

            int age = nextRandomInt(40, 51);

            employees[i] = new Employee(
                    fullName,
                    "Разработчик",
                    email,
                    phoneNumber,
                    salary,
                    age);
        }

        for (Employee emp : employees) {
            if (emp.age > 40) {
                emp.printInConsole();
            }
        }
    }
}
