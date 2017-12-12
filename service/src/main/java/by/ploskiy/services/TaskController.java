package by.ploskiy.services;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.Task;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskController {

    //TODO: Тут нужно создать лист роботов. При каждом запросе листа задач раздавать задачи роботам.
    //TODO: Возможно ещё потребуется создать общий лог, он то и будет контролировать весь процесс.

    private static List<Task> tasks = new LinkedList<Task>();


    public synchronized void addTask(Task task){
        tasks.add(task);
    }

    public synchronized Task getTask(){
        Task tmpTask = tasks.get(0);
        tasks.remove(0);
        return tmpTask;
    }

    public synchronized List<Task> showTaskList() {


        return tasks;
    }


}
