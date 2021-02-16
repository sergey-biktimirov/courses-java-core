package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson4;

/**
 * 1. Создать три потока,
 * каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */
public class Task1 {


    private final Object sem = new Object();
    private volatile char aChar = 'A';

    private final char A = 'A';
    private final char B = 'B';
    private final char C = 'C';
    private static final int iterCount = 5;

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        new Thread(task1::printA).start();
        new Thread(task1::printB).start();;
        new Thread(task1::printC).start();;
    }

    public void printA() {
        synchronized (sem) {
            try {
                for (int i = 0; i < iterCount; i++) {
                    while (aChar != A) {
                        sem.wait();
                    }
                    System.out.print(A);
                    aChar = B;
                    sem.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (sem) {
            try {
                for (int i = 0; i < iterCount; i++) {
                    while (aChar != B) {
                        sem.wait();
                    }
                    System.out.print(B);
                    aChar = C;
                    sem.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (sem) {
            try {
                for (int i = 0; i < iterCount; i++) {
                    while (aChar != C) {
                        sem.wait();
                    }
                    System.out.print(C);
                    aChar = A;
                    sem.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

