package by.ploskiy.entitys;

public class RealRobot extends BaseRobot {

    public void doTask(Task task) {
        System.out.println("Получил задание.");
        System.out.println("Делаю...");
        System.out.println("Закончил.");
    }
}
