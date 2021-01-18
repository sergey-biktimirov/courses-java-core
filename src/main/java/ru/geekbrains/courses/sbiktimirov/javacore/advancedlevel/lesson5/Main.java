package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson5;

import java.util.Arrays;

public class Main {

    static final int arrSize = 20000000;
    static final int splitArrSize = arrSize / 2;

    static float[] arr = new float[arrSize];

    static {
        Arrays.fill(arr, 1);
    }

    public static void main(String[] args) {

        calculateArrayData();

        parallelCalculateArrayData();
    }

    static void calculateArrayData() {
        System.out.println("-->> Расчет массива в одном потоке");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = calculateArrayValue(arr[i], i);
        }

        System.out.println("Время расчета = " + (System.currentTimeMillis() - startTime) + " мс");
        System.out.println("--<< Расчет массива в одном потоке");
        System.out.println();
    }

    static void parallelCalculateArrayData() {
        System.out.println("-->> Разделение массива на два");

        float[] arr1 = new float[splitArrSize];
        float[] arr2 = new float[splitArrSize];

        long startSplitArray = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, splitArrSize);
        System.arraycopy(arr, splitArrSize, arr2, 0, splitArrSize);

        System.out.println("Затраченное время = " + (System.currentTimeMillis() - startSplitArray) + " мс");
        System.out.println("--<< Разделение массива на два");
        System.out.println();

        Thread t1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = calculateArrayValue(arr1[i], i);
            }

            System.out.println("-->> Расчет разделенного массива в первом потоке");
            System.out.println("-->> Поток 1");
            System.out.println("Время расчета = " + (System.currentTimeMillis() - startTime) + " мс");
            System.out.println("--<< Поток 1");
            System.out.println();
        });

        Thread t2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = calculateArrayValue(arr2[i], i);
            }

            System.out.println("-->> Расчет разделенного массива в втором потоке");
            System.out.println("-->> Поток 2");
            System.out.println("Время расчета = " + (System.currentTimeMillis() - startTime) + " мс");
            System.out.println("--<< Поток 2");
            System.out.println();
        });

        t1.start();
        t2.start();

        System.out.println("-->> Склеевание двух массивов в один");

        long startGluingArray = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arr, 0, splitArrSize);
        System.arraycopy(arr2, 0, arr, splitArrSize, splitArrSize);

        System.out.println("Затраченное время = " + (System.currentTimeMillis() - startGluingArray) + " мс");
        System.out.println("--<< Склеевание двух массивов в один");
        System.out.println();
    }

    static float calculateArrayValue(float val, int arrayIndex) {
        return (float) (
                val
                        * Math.sin(0.2f + arrayIndex / 5) * Math.cos(0.2f + arrayIndex / 5)
                        * Math.cos(0.4f + arrayIndex / 2));
    }
}