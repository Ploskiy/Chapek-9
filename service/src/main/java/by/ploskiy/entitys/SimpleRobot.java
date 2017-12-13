package by.ploskiy.entitys;

import by.ploskiy.services.LogController;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class SimpleRobot extends BaseRobot {

    private static List<String> robotLog = new ArrayList<String>();
    private Task task = null;

    public void setTaskForRobot(Task task) {
        this.task = task;
    }

    public void doTask() {
        if(task.getType().equals(TaskTypeEnum.SELF_DESTRUCTION)) {
            robotLog.add(getName() + "получил задание:" + task.getTitle());
            robotLog.add("Самоуничтожение..." );
        } else {
            robotLog.add(getName() + " получил задание:" + task.getTitle());
            robotLog.add("Делаю..." );
            loadProcess();
            robotLog.add("Закончил задание.");
        }
    }

    public void run() {
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());

        if (task != null){
            System.out.printf("2 Поток %s начал работу... \n", Thread.currentThread().getName());
            doTask();
            System.out.println(robotLog);
            task = null;
        }
        System.out.printf("Поток %s закончил работу... \n", Thread.currentThread().getName());
    }

    public List<String> getRobotLog() {
        return robotLog;
    }

    public void loadProcess(){
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i <= 10; i++){
            for (int l = 0; l < i; l++) {
                stringBuilder.append("=");
            }
            stringBuilder.append("" + i * 10 + "%");

            robotLog.remove(robotLog.size()-1);
            robotLog.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    public boolean isFree(){
        System.out.println(task);
        return task == null;
    }

//    public void showLog() {
//        for (String s : robotLog ) {
//            System.out.println(s);
//        }
//        System.out.println("-=-=---=-=-=");
//    }
}
