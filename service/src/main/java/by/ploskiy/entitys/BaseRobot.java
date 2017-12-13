package by.ploskiy.entitys;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
@ToString
public abstract class BaseRobot implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void doTask();
    public abstract boolean isFree();
    public abstract void setTaskForRobot(Task task);
    public abstract List<String> getRobotLog();
}
