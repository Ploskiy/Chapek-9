package by.ploskiy.entitys;

import java.util.ArrayList;
import java.util.List;

public class SimpleRobot extends BaseRobot {

    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION)) {
            addRobotLogString(getName() + "получил задание:" + getTask().getTitle());
            addRobotLogString("Самоуничтожение..." );
        } else {
            addRobotLogString(getName() + " получил задание:" + getTask().getTitle());
            addRobotLogString("Делаю..." );
            loadProcess();
            addRobotLogString("Закончил задание.");
        }
    }

    public void run() {
//        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());

        if (getTask() != null){
            doTask();
            System.out.println(getRobotLog());
            setTask(null);
        }
//        System.out.printf("Поток %s закончил работу... \n", Thread.currentThread().getName());
    }

    private void loadProcess(){
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i <= 10; i++){
            for (int l = 0; l < i; l++) {
                stringBuilder.append("=");
            }
            stringBuilder.append("").append(i * 10).append("%");

            robotLogRemoveLastString();
            addRobotLogString(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }
}
