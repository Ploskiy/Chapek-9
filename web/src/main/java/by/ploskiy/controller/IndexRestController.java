package by.ploskiy.controller;

import by.ploskiy.entitys.BaseRobot;
import by.ploskiy.entitys.Task;
import by.ploskiy.entitys.TaskTypeEnum;
import by.ploskiy.services.LogController;
import by.ploskiy.services.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexRestController {

    @Autowired
    private final TaskController taskController;

    @Autowired
    private final LogController logController;

//    private Task task;


    public IndexRestController(TaskController taskController, LogController logController){
        this.taskController = taskController;
        this.logController = logController;
    }

    @GetMapping("/controllerTaskList")
    public List<Task> controllerTaskList(){
        return taskController.showTaskList();
    }

    @GetMapping("/controllerLogList")
    public List<String> controllerLogList(){
        return logController.getAllLogList();
    }

    @PostMapping("/addTaskToController")
    public void addTask(@RequestBody String dataButton){
        Task task = new Task();
        task.setTitle(TaskTypeEnum.valueOf(dataButton.replaceAll("=", "")).getDescription());
        task.setType(dataButton.replaceAll("=", ""));
        taskController.addTask(task);
    }

    @GetMapping("/allComandsForRobots")
    public TaskTypeEnum[] allComandsForRobots() {
        return TaskTypeEnum.values();
    }

    @GetMapping("/allRobots")
    public List<BaseRobot> allRobots() {
        return taskController.getRobotList();
    }
}
