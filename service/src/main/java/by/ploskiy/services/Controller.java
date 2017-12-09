package by.ploskiy.services;

import by.ploskiy.entitys.Task;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
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
