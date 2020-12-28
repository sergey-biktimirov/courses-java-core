package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.being.human;

import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Hurdle;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Treadmill;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.athletics.Athlete;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson1.sport.Wall;

/**
 * Человек спортсмен
 */
public class HumanAthlete extends Human implements Athlete {

    public HumanAthlete(String name, int age, double growth, double weight, Gender gender) {
        super(name, age, growth, weight, gender);
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
    public HumanAthlete setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public HumanAthlete setMaxRunValue(double value) {
        super.setMaxRunValue(value);
        return this;
    }

    @Override
    public HumanAthlete setMaxJumpValue(double value) {
        super.setMaxJumpValue(value);
        return this;
    }
}
