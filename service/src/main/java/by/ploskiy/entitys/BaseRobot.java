package by.ploskiy.entitys;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public interface BaseRobot {

    public abstract void doTask(Task task);
}
