package by.ploskiy;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.Task;
import by.ploskiy.services.FactoryRobots;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRobots {



//    private final FactoryRobots factoryRobots;
//    private final SimpleRobot simpleRobot;
    private final Task task;

    @Autowired
    public TestRobots(FactoryRobots factoryRobots, SimpleRobot simpleRobot, Task task) {
//        this.factoryRobots = factoryRobots;
//        this.simpleRobot = simpleRobot;
        this.task = task;
    }


    @Test
    public void TestRobotsFactory() {
//        BaseRobot robot = simpleRobot;

        System.out.println(task);
//        BaseRobot robot2 = factoryRobots.getRobot();
//        BaseRobot robot3 = factoryRobots.getRobot();


//        robot.doTask(new Task("asdf", "asdf"));
//        System.out.println(robot);
//        System.out.println(robot2);
//        System.out.println(robot3);
    }
}
