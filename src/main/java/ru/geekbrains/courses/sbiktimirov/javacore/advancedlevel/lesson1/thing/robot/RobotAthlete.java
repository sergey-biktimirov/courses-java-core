package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.thing.robot;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Hurdle;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.athletics.Athlete;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Treadmill;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Wall;

/**
 * Робот спортсмен
 */
public class RobotAthlete extends RobotHumanoid implements Athlete {

    public RobotAthlete(String name, String model) {
        super(name, model);
    }

    /**
     * Преодоление препятствий
     *
     * @param hurdle - препятствие
     * @return - true - преодолено, false - не преодолено
     */
    @Override
    public boolean makeHurdle(Hurdle hurdle) {
        boolean b = false;

        if (hurdle instanceof Treadmill) {
            b = run(hurdle.getValue());
        } else if (hurdle instanceof Wall) {
            b = jump(hurdle.getValue());
        }

        return b;
    }

    @Override
    public RobotAthlete setName(String name) {
        return this;
    }

    @Override
    public RobotAthlete setMaxRunValue(double value) {
        super.setMaxRunValue(value);
        return this;
    }

    @Override
    public RobotAthlete setMaxJumpValue(double value) {
        super.setMaxJumpValue(value);
        return this;
    }
}
