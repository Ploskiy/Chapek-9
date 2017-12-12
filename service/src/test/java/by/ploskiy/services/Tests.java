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

import java.util.ArrayList;
import java.util.List;

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
        SimpleRobot simpleRobot2 = new SimpleRobot();

        Task task1 = new Task("111", "222");
        Task task2 = new Task("333", "444");

        simpleRobot.setTaskForRobot(task1);
        simpleRobot2.setTaskForRobot(task2);

        Thread t1 = new Thread(simpleRobot, "robo1");
        Thread t2 = new Thread(simpleRobot2, "robo2");

        List<Thread> listThreads = new ArrayList<Thread>();
        listThreads.add(t1);
        listThreads.add(t2);

        listThreads.get(0).start();
        System.out.println(listThreads.size());
        listThreads.get(1).start();


        System.out.println("Поток отработал");

        System.out.println(listThreads.size());
    }
}
