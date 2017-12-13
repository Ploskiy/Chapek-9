package by.ploskiy.entitys;

import org.springframework.stereotype.Component;

import java.util.List;

public class StrongRobot extends BaseRobot {

    public void doTask() {
        System.out.println("Получил задание.");
        System.out.println("Делаю...");
        System.out.println("Закончил.");
    }

    public boolean isFree() {
        return false;
    }

    public void setTaskForRobot(Task task) {

    }

    public List<String> getRobotLog() {
        return null;
    }

    public void run() {

    }
}
