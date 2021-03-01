package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.util;

public class ReflectionUtils {

    public static Class<?> loadClass(String name) throws ClassNotFoundException {
        return ClassLoader.getSystemClassLoader().loadClass(name);
    }

    public static Class<?> loadClass(Class<?> clazz) throws ClassNotFoundException {
        return loadClass(clazz.getName());
    }



}
