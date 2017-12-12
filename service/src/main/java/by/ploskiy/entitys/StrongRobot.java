package by.ploskiy.entitys;

import org.springframework.stereotype.Component;

@Component
public class StrongRobot extends BaseRobot {

    public void doTask() {
        System.out.println("Получил задание.");
        System.out.println("Делаю...");
        System.out.println("Закончил.");
    }

    public boolean isBusy() {
        return false;
    }

    public void setTaskForRobot(Task task) {

    }

    public void run() {

    }
}
