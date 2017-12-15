package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Repository
@ToString
public abstract class BaseRobot implements Runnable {

//    @Autowired
//    TaskController taskController;

    private TaskController taskController = new TaskController();

    public void robotDestructor(String name) {
        taskController.removeRobotInList(name);
    }

    public String killHuman() {
        return taskController.findHuman();
    }

    @Getter
    private List<String> robotLog = new ArrayList<String>();

    public void addRobotLogString(String string) {
        robotLog.add(string);
    }

    public void robotLogClearAll() {
        while (robotLog.size() > 0){
            robotLog.remove(0);
        }
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Task task = null;

    public void run() {
        if (getTask() != null){
            doTask();
            setTask(null);
        }
    }

    public boolean isFree(){
        return task == null;
    }

    public abstract void doTask();
}
