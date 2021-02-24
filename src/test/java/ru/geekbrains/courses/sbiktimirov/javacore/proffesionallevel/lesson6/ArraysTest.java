package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson6;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

/**
 * Урок 6
 */
public class ArraysTest {

    @Rule
    public ExpectedException thrown  = ExpectedException.none();

    /**
     * Задание 1
     * Есть четверки в массиве, после последней 4 ожидается {1}
     */
    @Test
    @DisplayName("Есть четверки в массиве, после последней 4 ожидается {1}")
    public void getLastElementsFromArrayAfterElEq4Test() {
        Integer[] arr = {1, 2, 3, 4, 4, 4, 1, 1, 4, 1};
        Integer[] res = getLastElementsFromArrayAfterElEq4(arr);
        Integer[] expected = {1};
        assertArrayEquals(expected, res);
    }

    /**
     * Задание 1
     * Есть четверки но после последней четверки нет ничего
     */
    @Test
    @DisplayName("Есть четверки но после последней четверки нет ничего")
    public void getLastElementsFromArrayAfterElEq4EmptyArrayTest() {
        Integer[] arr = {1, 2, 3, 4, 4, 4, 1, 1, 4};
        Integer[] res = getLastElementsFromArrayAfterElEq4(arr);
        Integer[] expected = {};
        assertArrayEquals(expected, res);
    }
    /**
     * Задание 1
     * Нет четверок в массиве
     */
    @Test
    @DisplayName("Нет четверок в массиве")
    public void getLastElementsFromArrayAfterElEq4RuntimeExceptionTest() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Нет четверок в массиве");
        Integer[] arr = {1, 2, 3, 1, 1};
        getLastElementsFromArrayAfterElEq4(arr);
    }

    /**
     * Задание 2
     * Проверка наличия в массиве {1, 2, 3, 1} 1
     */
    @Test
    @DisplayName("Проверка наличия в массиве {1, 2, 3, 1} 1")
    public void checkExist1Or4InArrayWithMatchBy1() {
        Integer[] arr = {1, 2, 3, 1};
        boolean expected = true;
        assertEquals(expected, isExist1Or4InArray(arr));
    }

    /**
     * Задание 2
     * Проверка наличия в массиве {0, 2, 3, 4} 4
     */
    @Test
    @DisplayName("Проверка наличия в массиве {0, 2, 3, 4} 4")
    public void checkExist1Or4InArrayWithMatchBy4() {
        Integer[] arr = {0, 2, 3, 4};
        boolean expected = true;
        assertEquals(expected, isExist1Or4InArray(arr));
    }

    /**
     * Задание 2
     * Проверка наличия в массиве {1, 2, 3, 4} 1 или 4
     */
    @Test
    @DisplayName("Проверка наличия в массиве {1, 2, 3, 4} 1 или 4")
    public void checkExist1Or4InArrayWithMatchBy1And4() {
        Integer[] arr = {1, 2, 3, 4};
        boolean expected = true;
        assertEquals(expected, isExist1Or4InArray(arr));
    }

    /**
     * Задание 2
     * Проверка на наличие 1 и 4 в пустом массиве
     */
    @Test
    @DisplayName("Проверка на наличие 1 и 4 в пустом массиве")
    public void checkExist1Or4InEmptyArray() {
        Integer[] arr = {};
        boolean expected = false;
        assertEquals(expected, isExist1Or4InArray(arr));
    }

    /**
     * Задание 1
     * @param arr Проверяемый массив
     * @return массив чисел после 4
     */
    public Integer[] getLastElementsFromArrayAfterElEq4(Integer[] arr) {

        int lastIndexOf4 = Arrays.asList(arr).lastIndexOf(4);

        if (lastIndexOf4 < 0) throw new RuntimeException("Нет четверок в массиве");

        return Arrays.copyOfRange(arr, lastIndexOf4 + 1, arr.length);
    }

    /**
     * Задание 2
     * Проверка наличия 1 или 4 в массиве.
     * @param arr Проверяемый массив
     * @return true в массиве есть 1 или 4, false в массиве нет ни 1 ни 4.
     * */
    public boolean isExist1Or4InArray(Integer[] arr) {
        return Arrays.asList(arr).contains(1) || Arrays.asList(arr).contains(4);
    }
}
