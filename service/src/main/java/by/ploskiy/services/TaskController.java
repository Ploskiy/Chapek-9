package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TaskController {

    @Autowired
    private LogController logController;

    @Autowired
    private FactoryRobots factoryRobots;

    private static List<Task> taskLinkedList = new LinkedList<Task>();
    private static List<BaseRobot> robotsList = new ArrayList<BaseRobot>();
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public synchronized void addTask(Task task){
        logController.addStringToLog("Была добавлена задача: " + task.getTitle());
        taskLinkedList.add(task);
    }

    private synchronized Task getTask(){
        Task tmpTask = taskLinkedList.get(0);
        logController.addStringToLog("Задача \"" + taskLinkedList.get(0).getTitle() + "\" была отправлена роботу");
        taskLinkedList.remove(0);
        return tmpTask;
    }

    private void robotCreator() {
        robotsList.add(factoryRobots.getRobot());
    }

    public synchronized List<Task> showTaskList() {
        if(taskLinkedList.size() > 0) {

            if (taskLinkedList.size() > (robotsList.size() / 2)){
                robotCreator();
            }

            for (BaseRobot aRobotsList : robotsList) {
                if (aRobotsList.isFree()) {
                    aRobotsList.setTask(getTask());
                    executorService.submit(aRobotsList);
                }

                try {
                    wait(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                logController.addListToLog(aRobotsList.getRobotLog());
                logController.addStringToLog("¯\\_(ツ)_/¯ ¯\\_(ツ)_/¯ ¯\\_(ツ)_/¯");
            }
            return taskLinkedList;
        }

        return taskLinkedList;
    }
}
