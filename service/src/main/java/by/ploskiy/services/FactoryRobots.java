package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.ManInRobotCostume;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.WarriorRobot;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FactoryRobots {

    private long count = 0;

    public BaseRobot getRobot(){

        BaseRobot robot;

        switch (new Random().nextInt(5)) {
            case 0:
            case 1: robot = new SimpleRobot();
            break;

            case 2:
            case 3: robot = new WarriorRobot();
            break;

            case 4: robot = new ManInRobotCostume();
            break;

            default: robot = new SimpleRobot();
        }

        robot.setName(robot.getClass().getSimpleName() + count++);
        return robot;
    }
}
