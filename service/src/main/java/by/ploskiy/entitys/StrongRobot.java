package by.ploskiy.entitys;

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

    public void setTask(Task task) {

    }

    public void run() {

    }
}
