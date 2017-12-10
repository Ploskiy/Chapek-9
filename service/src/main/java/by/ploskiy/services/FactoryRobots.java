package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FactoryRobots {


//    private FactoryRobots() {
//    }
//
//    private static FactoryRobots instance;
//
//    public static FactoryRobots getInstans() {
//        if(instance == null){
//            instance = new FactoryRobots();
//        }
//        return instance;
//    }

    public BaseRobot getRobot(){
        BaseRobot robot = new SimpleRobot();
        return robot;
    }
}
