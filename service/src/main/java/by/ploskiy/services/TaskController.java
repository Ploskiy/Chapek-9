package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.ManInRobotCostume;
import by.ploskiy.entitys.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TaskController {

    @Autowired
    private LogController logController;

    @Autowired
    private FactoryRobots factoryRobots;

    private static List<Task> taskLinkedList = new LinkedList<Task>();
    private static List<BaseRobot> robotsList = new ArrayList<BaseRobot>();
    private ExecutorService executorService = Executors.newCachedThreadPool();


    public boolean findHuman() {
        for (BaseRobot aRobotsList : robotsList) {
            if(aRobotsList.getClass() == ManInRobotCostume.class) {
                robotsList.remove(aRobotsList);
                return true;
            }
        }

        return false;
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

    private void robotCreator() {
        robotsList.add(factoryRobots.getRobot());
    }


    public synchronized List<Task> showTaskList() {
        if(taskLinkedList.size() > 0) {
            taskControllerHub();
        }
        return taskLinkedList;
    }

    private void taskControllerHub() {
        if ((taskLinkedList.size() > (robotsList.size() / 2)) && (robotsList.size() < 6)){
            robotCreator();
        } else {
            logController.addStringToLog("Роботов слишком много.");
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

        System.out.println(robotName + "<==========================================");

        for (int i = 0; i < robotsList.size() - 1; i++) {
            if(robotsList.get(i).getName().equals(robotName)) {
                System.out.println("-=1=- " + robotsList.get(i).getName() + " - " + robotName);

                robotsList.remove(i);

                System.out.println("-=2=- " + robotsList.get(i).getName() + " - " + robotName);
            }
        }
    }

    public List<BaseRobot> getRobotList() {
        return robotsList;
    }
}
