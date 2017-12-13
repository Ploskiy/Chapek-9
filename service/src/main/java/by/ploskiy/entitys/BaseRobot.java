package by.ploskiy.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
@ToString
public abstract class BaseRobot implements Runnable {

//    @Setter
    @Getter
    private List<String> robotLog = new ArrayList<String>();

    public void addRobotLogString(String string) {
        robotLog.add(string);
    }

    public void robotLogRemoveLastString() {
        robotLog.remove(robotLog.size() - 1);
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Task task = null;


//    public abstract void setTask(Task task);

    public abstract void doTask();


//    public abstract boolean isFree();
    public boolean isFree(){
//        System.out.println(task);
        return task == null;
    }

//    public abstract List<String> getRobotLog();
//    public List<String> getRobotLog() {
//        return robotLog;
//    }
}
