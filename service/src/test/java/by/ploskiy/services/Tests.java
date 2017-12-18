package by.ploskiy.services;

import by.ploskiy.config.TestConfigServices;
import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.Task;
import by.ploskiy.entitys.TaskTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
public class Tests {

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

        simpleRobot.setTask(task1);
        simpleRobot2.setTask(task2);

        List<SimpleRobot> robotsList = new ArrayList<SimpleRobot>();
        robotsList.add(simpleRobot);
        robotsList.add(simpleRobot2);

        Thread t1 = new Thread(robotsList.get(0), "robo1");
        Thread t2 = new Thread(robotsList.get(1), "robo2");

        t1.start();
        t2.start();

        Thread t3 = new Thread(robotsList.get(0), "robo1");
        t3.start();

        System.out.println("Поток отработал");
    }

    @Test
    public void testRobotsTaskLog() {
        List<BaseRobot> robotsList = new ArrayList<BaseRobot>();
        robotsList.add(factoryRobots.getRobot());
        robotsList.add(factoryRobots.getRobot());

        Task task = new Task("111", "111");
        Task task2 = new Task("222", "222");

        ExecutorService executorService = Executors.newCachedThreadPool();

        robotsList.get(0).setTask(task);
        robotsList.get(1).setTask(task2);

        executorService.submit(robotsList.get(0));
        executorService.submit(robotsList.get(1));


        System.out.println(robotsList.get(0).getRobotLog().size());

        assertEquals(robotsList.get(0).getRobotLog().size(), 1);
    }

    @Test
    public void testEnumToMap() {
        Map<String, String> allTasksEnumMap = new HashMap<String, String>();
        for (TaskTypeEnum taskEnum: TaskTypeEnum.values()) {
            allTasksEnumMap.put(taskEnum.toString(), taskEnum.getDescription());
        }

        System.out.println(allTasksEnumMap);

    }
}
