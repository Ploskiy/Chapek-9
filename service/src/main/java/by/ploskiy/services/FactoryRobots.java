package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.StrongRobot;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FactoryRobots {

    private long count = 0;

    public BaseRobot getRobot(){
        BaseRobot robot = new SimpleRobot();
        robot.setName(robot.getClass().getSimpleName() + count++);
        return robot;
    }
}
