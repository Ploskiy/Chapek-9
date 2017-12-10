package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;

public class FactoryRobots {

    private FactoryRobots() {
    }

    private static FactoryRobots instance;

    public static FactoryRobots getInstans() {
        if(instance == null){
            instance = new FactoryRobots();
        }
        return instance;
    }

    public BaseRobot getRobot(){
        BaseRobot robot = new SimpleRobot();
        return robot;
    }
}
