package by.ploskiy.controller;

import by.ploskiy.entitys.Task;
import by.ploskiy.entitys.TaskEnum;
import by.ploskiy.services.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class IndexRestController {

    private final Task task;
    private final Controller controller;


    @Autowired
    public IndexRestController(Task task, Controller controller){
        this.task = task;
        this.controller = controller;
    }

    @GetMapping("/controllerTaskList")
    public List<Task> controllerTaskList(){
        return controller.showTaskList();
    }

    @PostMapping("/addTaskToController")
    public void addTask(@RequestBody Task task){
        System.out.println(task);
        controller.addTask(task);
    }

    @GetMapping("/allComandsForRobots")
    public TaskEnum[] allComandsForRobots() {
        return TaskEnum.values();
    }
}
