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
import java.util.LinkedList;
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

        List<SimpleRobot> robotsList = new ArrayList<SimpleRobot>();
        robotsList.add(simpleRobot);
        robotsList.add(simpleRobot2);

        Thread t1 = new Thread(robotsList.get(0), "robo1");
        Thread t2 = new Thread(robotsList.get(1), "robo2");

        t1.start();
        t2.start();

        Thread t3 = new Thread(robotsList.get(0), "robo1");
        t3.start();

//        try {
//            wait(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Поток отработал");
    }

    @Test
    public void testList() {
        List<String> test = new LinkedList<String>();
        List<String> test2 = new ArrayList<String>();



        test2.add("1");
        test2.add("2");
        test.add("3");
        test.add("4");

        test.addAll(test2);


        System.out.println(test);
    }
}
