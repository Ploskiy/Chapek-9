package by.ploskiy.entitys;

import java.util.ArrayList;
import java.util.List;

public class SimpleRobot extends BaseRobot {

//    private static List<String> robotLog = new ArrayList<String>();

//    public List<String> getRobotLog() {
//        return robotLog;
//    }

//    private Task task = null;

//    public void setTask(Task task) {
//        this.task = task;
//    }

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
//            System.out.printf("2 Поток %s начал работу... \n", Thread.currentThread().getName());
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

//    public boolean isFree(){
////        System.out.println(task);
//        return task == null;
//    }

//    public void showLog() {
//        for (String s : robotLog ) {
//            System.out.println(s);
//        }
//        System.out.println("-=-=---=-=-=");
//    }
}
