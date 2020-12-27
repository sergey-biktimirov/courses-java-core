package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.thing.robot;

import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.action.Jump;
import ru.geekbrains.courses.sbiktimirov.javacore.baselevel.advancedlevel.lesson1.being.action.Run;
import ru.geekbrains.courses.sbiktimirov.utl.StringUtl;

/**
 * Человеко подобный робот
 */
public class RobotHumanoid extends Robot implements Jump, Run {

    /**
     * Максимальная дистанция для бега,
     * По умолчанию 0
     */
    private double maxRunValue = 0;

    /**
     * Максимальная дистанция или высота для прыжка
     * По умолчанию 0
     */
    private double maxJumpValue = 0;

    public RobotHumanoid(String name, String model) {
        super(name, model);
    }

    /**
     * Бег
     *
     * @param v - дистанция бега
     *          По умолчанию 0
     */
    @Override
    public boolean run(double v) {
        return v > 0 && v <= getMaxRunValue();
    }

    /**
     * Прыжок
     * По умолчанию 0
     *
     * @param v - длина или высота прыжка
     */
    @Override
    public boolean jump(double v) {
        return v > 0 && v <= getMaxJumpValue();
    }

    public double getMaxRunValue() {
        return maxRunValue;
    }

    public RobotHumanoid setMaxRunValue(double value) {
        this.maxRunValue = value >= 0 ? value : 0;
        return this;
    }

    public double getMaxJumpValue() {
        return maxJumpValue;
    }

    public RobotHumanoid setMaxJumpValue(double value) {
        this.maxJumpValue = value >= 0 ? value : 0;
        return this;
    }
}
