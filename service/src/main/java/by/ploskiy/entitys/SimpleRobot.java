package by.ploskiy.entitys;

import by.ploskiy.services.LogController;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@ToString
public class SimpleRobot extends BaseRobot {

    public SimpleRobot() {
    }

    @Autowired
    private LogController logController;

    private List<String> robotLog = new ArrayList<String>();
    private Task task = new Task();

    public void setTaskForRobot(Task task) {
        this.task = task;
    }


    public void doTask() {
        if(task.getType().equals(TaskTypeEnum.SELF_DESTRUCTION)) {
            robotLog.add("Получил задание:" + task.getTitle());
            robotLog.add("Самоуничтожение..." );
        } else {
            robotLog.add("Получил задание:" + task.getTitle());
            robotLog.add("Делаю..." );
            loadProcess();
            robotLog.add("Закончил задание.");
        }

    }

    public void run() {
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        robotLog.add("Питание подано");
        robotLog.add("Загрузка процессора");

        if (task != null){
            doTask();
            loadRobotLogToGlobalLog();
            task = null;
        }
    }

    public void loadRobotLogToGlobalLog() {
        logController.addListtoLog(robotLog);
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
            System.out.println("-=1=-");
        }
    }

    public boolean isBusy(){
        if(task != null) {
            return true;
        }
        return false;
    }

//    public void showLog() {
//        for (String s : robotLog ) {
//            System.out.println(s);
//        }
//        System.out.println("-=-=---=-=-=");
//    }
}
