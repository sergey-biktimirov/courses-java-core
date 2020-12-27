package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.animal;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Hurdle;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.athletics.Athlete;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Treadmill;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.sport.Wall;

/**
 * Кот спортсмен
 */
public class CatAthlete extends Cat implements Athlete {

    public CatAthlete(String name, String color) {
        super(name, color);
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
    public CatAthlete setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public CatAthlete setMaxRunValue(double value) {
        super.setMaxRunValue(value);
        return this;
    }

    @Override
    public CatAthlete setMaxJumpValue(double value) {
        super.setMaxJumpValue(value);
        return this;
    }
}
