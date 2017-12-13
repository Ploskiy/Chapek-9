package by.ploskiy.entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManInRobotCostume extends BaseRobot {

//    private static List<String> robotLog = new ArrayList<String>();


    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION)) {
            addRobotLogString(getName() + "получил задание:" + getTask().getTitle());

            switch (new Random().nextInt(5)){
                case 1 : addRobotLogString("Нужно где то спрятаться ..." );
                    break;
                case 2 : addRobotLogString("Маскируемся деревом ... " );
                    break;
                case 3 : addRobotLogString("Притварюсь что задача закончилась ошибкой ..." );
                    break;
                default: addRobotLogString("Паника ... Началась охота на \"Человеков\"" );
            }

        } else {
            addRobotLogString(getName() + " получил задание:" + getTask().getTitle());
            addRobotLogString("Нужно притвориться, что я делаю работу" );
            addRobotLogString("Пик, ПИК, пик. Что это вообще за задание такое?" );
            addRobotLogString("Закончил задание.");
        }
    }

    public boolean isFree() {
        return false;
    }

//    public List<String> getRobotLog() {
//        return null;
//    }

    public void run() {

    }
}
