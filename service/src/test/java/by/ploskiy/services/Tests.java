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
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
public class Tests {

    @Autowired
    private FactoryRobots factoryRobots;

    @Autowired
    private Task task;


    @Test
    public void robotsFactoryTest() {
        BaseRobot robot = factoryRobots.getRobot();
        BaseRobot robot1 = factoryRobots.getRobot();

        Assert.assertNotEquals(robot, robot1);
    }

    @Test
    public void threadRobotsTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final BaseRobot robot = factoryRobots.getRobot();
        final BaseRobot robot1 = factoryRobots.getRobot();

        Task task1 = new Task("111", "222");
        Task task2 = new Task("333", "444");

        Future<Boolean> taskForRobot = executorService.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return robot.isFree();
            }
        });

        Future<Boolean> taskForRobot1 = executorService.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return robot1.isFree();
            }
        });


        try {
            assertTrue(taskForRobot.get() && taskForRobot1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void robotsLogTest() {
        final List<BaseRobot> robotsList = new ArrayList<BaseRobot>();
        robotsList.add(factoryRobots.getRobot());
        robotsList.add(factoryRobots.getRobot());

        Task task = new Task("111", "111");
        Task task2 = new Task("222", "222");

        ExecutorService executorService = Executors.newCachedThreadPool();

        robotsList.get(0).setTask(task);
        robotsList.get(1).setTask(task2);

        executorService.submit(robotsList.get(0));
        executorService.submit(robotsList.get(1));

        Future<List<String>> logListAfterTaskForRobot = executorService.submit(new Callable<List<String>>() {
            public List<String> call() throws Exception {
                return robotsList.get(0).getRobotLog();
            }
        });

        Future<List<String>> logListAfterTaskForRobot1 = executorService.submit(new Callable<List<String>>() {
            public List<String> call() throws Exception {
                return robotsList.get(1).getRobotLog();
            }
        });


        try {
            assertTrue((logListAfterTaskForRobot.get().size() > 0) && (logListAfterTaskForRobot1.get().size() > 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
