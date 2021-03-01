package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.engine;

import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.AfterSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.BeforeSuite;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.annotation.Test;
import ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson7.simpletester.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTesterEngine {

    private static Class<?> _clazz;
    private static Object _testInstance;
    private static List<Method> _testMethods;
    private static List<Method> _beforeSuiteMethods;
    private static List<Method> _afterSuiteMethods;

    public static void start(Class<?> clazz) {
        try {
            _clazz = ReflectionUtils.loadClass(clazz);
            runTest();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void start(String name) {
        try {
            _clazz = ReflectionUtils.loadClass(name);
            runTest();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws RuntimeException
     * */
    private static void init() throws RuntimeException, IllegalAccessException, InstantiationException {
        _beforeSuiteMethods = getBeforeSuiteMethods();
        _afterSuiteMethods = getAfterSuiteMethods();

        if (_beforeSuiteMethods.size() > 1) {
            throw new RuntimeException("Указано больше одного BeforeSuite");
        }

        if (_afterSuiteMethods.size() > 1) {
            throw new RuntimeException("Указано больше одного AfterSuite");
        }

        _testInstance = _clazz.newInstance();

        _testMethods = getTestMethods();

    }

    private static void invokeMethod(String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        _testInstance.getClass().getMethod(name).invoke(_testInstance);
    }

    private static void runTest() throws InstantiationException, IllegalAccessException {
        init();

        try {

            for (Method method : _beforeSuiteMethods) {
               invokeMethod(method.getName());
            }

            for (Method method : _testMethods) {
                invokeMethod(method.getName());
            }

            for (Method method : _afterSuiteMethods) {
                invokeMethod(method.getName());
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static List<Method> getTestMethods() {
        return Arrays
                .stream(_clazz.getDeclaredMethods())
                .filter(SimpleTesterEngine::isTestMethod)
                .sorted(Comparator.comparingInt(o -> o.getDeclaredAnnotation(Test.class).priority()))
                .collect(Collectors.toList());
    }

    public static List<Method> getBeforeSuiteMethods() {
        return Arrays
                .stream(_clazz.getDeclaredMethods())
                .filter(SimpleTesterEngine::isBeforeSuiteMethod)
                .collect(Collectors.toList());
    }

    public static List<Method> getAfterSuiteMethods() {
        return Arrays
                .stream(_clazz.getDeclaredMethods())
                .filter(SimpleTesterEngine::isAfterSuiteMethod)
                .collect(Collectors.toList());
    }

    private static boolean isTestMethod(Method method) {
        return method.isAnnotationPresent(Test.class);
    }

    private static boolean isBeforeSuiteMethod(Method method) {
        return method.isAnnotationPresent(BeforeSuite.class);
    }

    private static boolean isAfterSuiteMethod(Method method) {
        return method.isAnnotationPresent(AfterSuite.class);
    }
}
