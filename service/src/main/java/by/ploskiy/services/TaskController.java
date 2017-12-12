package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.SimpleRobot;
import by.ploskiy.entitys.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TaskController {

    //TODO: Тут нужно создать лист роботов. При каждом запросе листа задач раздавать задачи роботам.
    //TODO: Возможно ещё потребуется создать общий лог, он то и будет контролировать весь процесс.
    @Autowired
    private LogController logController;

    @Autowired
    private FactoryRobots factoryRobots;


    private static List<Task> tasks = new LinkedList<Task>();
    private static List<BaseRobot> robotsList = new ArrayList<BaseRobot>();
//    ExecutorService service = Executors.newCachedThreadPool();

    public synchronized void addTask(Task task){
        logController.addStringToLog("Была добавлена задача: " + task.getTitle());
        tasks.add(task);

        if(tasks.size() > (robotsList.size() / 2)) {
            robotCreator();
        }
    }

    public synchronized Task getTask(){
        Task tmpTask = tasks.get(0);
        logController.addStringToLog("Задача \"" + tasks.get(0).getTitle() + "\" была отправлена роботу");
        tasks.remove(0);
        return tmpTask;
    }

    public void robotCreator() {
        robotsList.add(factoryRobots.getRobot());
    }

    public synchronized List<Task> showTaskList() {

        System.out.println("-=-=-=-=--=-=-=-");
        System.out.println(tasks.size());
        System.out.println(robotsList.size());

        if(tasks.size() > 0) {
            BaseRobot robot1 = robotsList.get(0);
            robot1.setTaskForRobot(getTask());
            Thread t1 = new Thread(robot1);
            t1.start();
            return tasks;
        }

        return tasks;
    }


}
