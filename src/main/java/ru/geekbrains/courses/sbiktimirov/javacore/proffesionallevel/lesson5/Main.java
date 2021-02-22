package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 10;
    public static final CyclicBarrier tunnel = new CyclicBarrier(CARS_COUNT / 2);
    public static final CountDownLatch preparing = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch finish = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        /**
         * Ожидание подготовки
         * */
        preparing.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");



        /**
         * Ожидание прохождения всех препятствий всеми гонщиками
         * */
        finish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static synchronized void finish(Car car) {
        if (Main.finish.getCount() == Main.CARS_COUNT) {
            System.out.println("===========____1____=============" + " - ым");
            System.out.println(car.getName() + " Победил в гонке!!!!");
            System.out.println("=================================");
        } else {
            long n = Main.CARS_COUNT - Main.finish.getCount() + 1;
            System.out.println("===========____"+ n + "____=============");
            System.out.println(car.getName() + " Закончил гонку " + n + " - ым");
            System.out.println("=================================");
        }

        Main.finish.countDown();
    }
}