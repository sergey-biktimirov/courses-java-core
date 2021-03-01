package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Выполняется до всех тестируемых методов
 * Возможно только одно объявление в тестируемом классе,
 * иначе будет выброшено исключение
 * @throws RuntimeException
 * @see Test
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface BeforeSuite {}
