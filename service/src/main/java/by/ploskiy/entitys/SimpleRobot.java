package by.ploskiy.entitys;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@ToString
public class SimpleRobot implements BaseRobot {

    public SimpleRobot() {
    }

    public void doTask(Task task) {
        System.out.println("Получил задание.");
        System.out.println("Делаю...");
        System.out.println("Закончил.");
    }
}
