package by.ploskiy.services;

import by.ploskiy.config.TestConfigServices;
import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
public class Tests {

//    private final Task task;

    @Autowired
    private FactoryRobots factoryRobots;

    @Autowired
    private Task task;


    @Test
    public void RobotsFactoryTest() {
        BaseRobot robot = factoryRobots.getRobot();
        BaseRobot robot1 = factoryRobots.getRobot();

        Assert.assertNotEquals(robot, robot1);
    }

    @Test
    public void threadRobotsTest() {
        BaseRobot robot = factoryRobots.getRobot();
        BaseRobot robot1 = factoryRobots.getRobot();
        SimpleRobot simpleRobot = new SimpleRobot();

        task.setTitle("111");
        task.setType("222");

        simpleRobot.setTaskForRobot(task);

        new Thread(simpleRobot, "robo1").start();
    }
}
