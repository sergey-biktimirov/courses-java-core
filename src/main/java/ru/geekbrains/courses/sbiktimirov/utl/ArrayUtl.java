package ru.geekbrains.courses.sbiktimirov.utl;

import java.util.Arrays;

public class ArrayUtl {

    public static String arrAsString(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) sb.append(", ");
            sb.append(Arrays.toString(arr[i]));
        }

        sb.append("]");

        return sb.toString();
    }

    public static String arrAsString(String[] arr) {
        return Arrays.toString(arr);
    }
}
