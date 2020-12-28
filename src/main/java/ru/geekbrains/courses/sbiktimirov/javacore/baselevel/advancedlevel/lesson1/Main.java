package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.animal.CatAthlete;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.human.Gender;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.human.HumanAthlete;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Hurdle;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Treadmill;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Wall;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.athletics.Athlete;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.thing.robot.RobotAthlete;
import ru.geekbrains.courses.sbiktimirov.utl.StringUtl;

import java.util.Arrays;
import java.util.List;

import static ru.geekbrains.courses.sbiktimirov.utl.MathUtl.nextRandomDouble;
import static ru.geekbrains.courses.sbiktimirov.utl.MathUtl.nextRandomInt;

/*
1. Создайте три класса Человек, Кот, Робот,
 которые не наследуются от одного класса.
 Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена,
 при прохождении через которые,
 участники должны выполнять соответствующие действия (бежать или прыгать),
 результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями,
 и заставьте всех участников пройти этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены),
 а участников ограничения на бег и прыжки.
 Если участник не смог пройти одно из препятствий,
 то дальше по списку он препятствий не идет.
* */
public class Main {

    static final double MIN_TREADMILL_LENGTH = 20;
    static final double MAX_TREADMILL_LENGTH = 100;

    static final double MIN_WALL_HEIGHT = 0.1;
    static final double MAX_WALL_HEIGHT = 0.5;

    public static void main(String[] args) {

        /*
         * Список препятствий
         */
        List<Hurdle> hurdles = getHurdlesList();

        /*
         * Прохождение препятствий
         */
        for (Athlete athlete : getAthletesList()) {
            boolean b = false;
            for (Hurdle hurdle : hurdles) {
                b = printOvercomingResult(athlete, hurdle);
                if (!b) break;
            }

            System.out.printf("Спортсмен \"%s\" %sпрошел испытание%n", athlete.getName(), !b ? "не " : "");
            System.out.println();
        }
    }

    static boolean printOvercomingResult(Athlete athlete, Hurdle hurdle) {
        String msg = String.format("%s - неизвестное препятствие%n", hurdle.getDefinition());

        boolean b = false;

        if (hurdle instanceof Treadmill) {
            b = athlete.makeHurdle(hurdle);

            msg = String.format(
                    "%s %sпробежал беговую дорожку %.2f %s%n",
                    athlete.getName(),
                    !b ? "не " : "",
                    hurdle.getValue(),
                    StringUtl.getMeterWord((int) hurdle.getValue(), "метр", "метра", "метров")
            );
        } else if (hurdle instanceof Wall) {
            b = athlete.makeHurdle(hurdle);

            msg = String.format(
                    "%s %sперепрыгнул стену высотой %.2f %s%n",
                    athlete.getName(),
                    !b ? "не " : "",
                    hurdle.getValue(),
                    StringUtl.getMeterWord((int) hurdle.getValue(), "метр", "метра", "метров")
            );
        }

        System.out.print(msg);
        return b;
    }

    /**
     * Список спортсменов
     */
    static List<Athlete> getAthletesList() {
        return Arrays.asList(
                new CatAthlete("Просто кот", "Белый")
                        .setMaxRunValue(nextRandomDouble(MIN_WALL_HEIGHT * 1.2, MAX_WALL_HEIGHT * 1.2))
                        .setMaxJumpValue(nextRandomDouble(MIN_WALL_HEIGHT * 1.2, MAX_WALL_HEIGHT * 1.2)),
                new RobotAthlete("Просто робот", "Athletic-T800")
                        .setMaxRunValue(nextRandomDouble(MIN_TREADMILL_LENGTH * 1.2, MAX_TREADMILL_LENGTH * 1.2))
                        .setMaxJumpValue(nextRandomDouble(MIN_WALL_HEIGHT * 1.2, MAX_WALL_HEIGHT * 1.2)),
                new HumanAthlete(
                        "Победитель",
                        nextRandomInt(18, 30),
                        nextRandomInt(170, 200),
                        nextRandomDouble(40.0, 60.0),
                        Gender.MALE)
                        .setMaxRunValue(nextRandomDouble(MIN_TREADMILL_LENGTH * 10, MAX_TREADMILL_LENGTH * 10))
                        .setMaxJumpValue(nextRandomDouble(MIN_WALL_HEIGHT * 10, MAX_WALL_HEIGHT * 10))
        );
    }

    /**
     * Список препятствий
     */
    static List<Hurdle> getHurdlesList() {
        return Arrays.asList(
                new Treadmill("Беговая дорожка",
                        nextRandomDouble(MIN_TREADMILL_LENGTH, MAX_TREADMILL_LENGTH)),
                new Wall("Барьер", nextRandomDouble(MIN_WALL_HEIGHT, MAX_WALL_HEIGHT)),
                new Treadmill("Беговая дорожка",
                        nextRandomDouble(MIN_TREADMILL_LENGTH, MAX_TREADMILL_LENGTH)),
                new Treadmill("Беговая дорожка",
                        nextRandomDouble(MIN_TREADMILL_LENGTH, MAX_TREADMILL_LENGTH)),
                new Wall("Барьер", nextRandomDouble(MIN_WALL_HEIGHT, MAX_WALL_HEIGHT)),
                new Wall("Барьер", nextRandomDouble(MIN_WALL_HEIGHT, MAX_WALL_HEIGHT)),
                new Wall("Барьер", nextRandomDouble(MIN_WALL_HEIGHT, MAX_WALL_HEIGHT)),
                new Wall("Барьер", nextRandomDouble(MIN_WALL_HEIGHT, MAX_WALL_HEIGHT))
        );
    }
}
