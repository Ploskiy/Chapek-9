package by.ploskiy.entitys;

import org.springframework.stereotype.Component;

@Component
public class RealRobot implements BaseRobot {

    public void doTask(Task task) {
        System.out.println("Получил задание.");
        System.out.println("Делаю...");
        System.out.println("Закончил.");
    }
}
