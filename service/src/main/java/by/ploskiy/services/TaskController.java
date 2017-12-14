package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.ManInRobotCostume;
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


    public String findHuman() {
        for (BaseRobot aRobotsList : robotsList) {
            if(aRobotsList.getClass() == ManInRobotCostume.class) {
                String name = aRobotsList.getName();
                removeRobotInList(name);
                return name;
            }
        }

        return null;
    }

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

    public void createRobot() {
        if (robotsList.size() < 6){
            robotsList.add(factoryRobots.getRobot());
        } else {
            logController.addStringToLog("Роботов слишком много.");
        }

    }

    public synchronized List<Task> showTaskList() {
        if(taskLinkedList.size() > 0) {
            taskControllerHub();
        }
        return taskLinkedList;
    }

    private void taskControllerHub() {
        if (taskLinkedList.size() > (robotsList.size() / 2)){
            createRobot();
        }

        for (BaseRobot aRobotsList : robotsList) {
            if (aRobotsList.isFree()) {
                aRobotsList.setTask(getTask());

                try {
                    executorService.submit(aRobotsList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                wait(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logController.addListToLog(aRobotsList.getRobotLog());
            logController.addStringToLog("~~~~~~~~~~~~~~~~~");
        }
    }

    public void removeRobotInList(String robotName) {
        for (int i = 0; i < robotsList.size() - 1; i++) {
            if(robotsList.get(i).getName().equals(robotName)) {
                robotsList.remove(i);
            }
        }
    }

    public List<BaseRobot> getRobotList() {
        return robotsList;
    }
}
