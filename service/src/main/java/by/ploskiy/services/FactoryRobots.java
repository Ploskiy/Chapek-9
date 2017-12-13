package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import org.springframework.stereotype.Service;

@Service
public class FactoryRobots {

    private long count = 0;

    public BaseRobot getRobot(){
        BaseRobot robot = new SimpleRobot();
        robot.setName(robot.getClass().getSimpleName() + count++);
        return robot;
    }
}
