package by.ploskiy.entitys;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseRobot implements Runnable {

    public abstract void doTask();
    public abstract boolean isBusy();
    public abstract void setTaskForRobot(Task task);
}
