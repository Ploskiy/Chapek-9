package by.ploskiy.services;

import by.ploskiy.entitys.Task;

import java.util.LinkedList;
import java.util.List;


public class Controller {

    private static List<Task> tasks = new LinkedList<Task>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeFirstTask(){
        tasks.remove(0);
    }

    public List<Task> showTaskList() {
        return tasks;
    }
}
