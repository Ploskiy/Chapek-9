package by.ploskiy.services;

import by.ploskiy.entitys.Task;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskController {

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
