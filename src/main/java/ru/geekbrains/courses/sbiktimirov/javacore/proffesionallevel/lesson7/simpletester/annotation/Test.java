package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Маркер для тестируемых методов
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface Test {
    /**
     * Приоритет выполнения
     * Одинаковые приоритеты тестируемых методов будут выполнятся в случайном порядке
     * */
    int priority() default 0;
}
