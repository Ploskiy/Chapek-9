package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
@ToString
public abstract class BaseRobot implements Runnable {

    @Getter
    @Setter
    @Autowired
    private TaskController taskController;

    @Getter
    private List<String> robotLog = new ArrayList<String>();

    public void addRobotLogString(String string) {
        robotLog.add(string);
    }

    public void robotLogRemoveLastString() {
        robotLog.remove(robotLog.size() - 1);
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
            System.out.println(getRobotLog());
            setTask(null);
        }
    }

    public abstract void doTask();

    public boolean isFree(){
        return task == null;
    }
}
