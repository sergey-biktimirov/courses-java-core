package ru.geekbrains.courses.sbiktimirov.javacore.proffesionallevel.lesson5;


public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

                /**
                 * Если количество машин не четное, тогда тогда барьер сдвигается на 1
                 * */
                if (Main.CARS_COUNT % 2 != 0) {
                    Main.tunnel.await();
                }

                Main.tunnel.await();

                System.out.println(c.getName() + " начал этап: " + description);

                Thread.sleep(length / c.getSpeed() * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
