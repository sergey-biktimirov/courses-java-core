package ru.geekbrains.courses.sbiktimirov.utl;

import java.util.Arrays;

public class Utl {

    public static void printTaskNumber(int taskNum) {
        System.out.println("Задание № " + taskNum);
    }

    public static void printMsg(String taskMsg) {
        System.out.println(taskMsg);
    }

    public static void printNextTaskLine() {
        System.out.println("--------------------------------\n");
    }

    public static void printBeforeMsg(int[] arr) {
        System.out.println("   До: " + Arrays.toString(arr));
    }

    public static void printAfterMsg(int[] arr) {
        System.out.println("После: " + Arrays.toString(arr));
    }

    public static void printBeforeMsg(int[][] arr) {
        System.out.println("   До: ");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void printAfterMsg(int[][] arr) {
        System.out.println("После: ");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void printMsg(String msg, int[] arr){
        System.out.println(msg + " " + Arrays.toString(arr));
    }

}