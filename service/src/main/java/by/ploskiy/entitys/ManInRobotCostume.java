package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManInRobotCostume extends BaseRobot {

    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION)) {
            robotLogClearAll();

            switch (new Random().nextInt(3)){
                case 0 : addRobotLogString(getName() + "получил задание:" + getTask().getTitle() + "\n" + "Нужно где то спрятаться ...");
                    break;
                case 1 : addRobotLogString(getName() + "получил задание:" + getTask().getTitle() + "\n" + "Маскируемся деревом ... " );
                    break;
                case 2 : addRobotLogString(getName() + "получил задание:" + getTask().getTitle() + "\n" + "Смотрите! Человеки!" );
                    break;
                default: addRobotLogString(getName() + "получил задание:" + getTask().getTitle() + "\n" + "Паника ... Началась охота на \"Человеков\"" );
            }

            getTaskController().removeRobotInList(getName());

        } else {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание:" + getTask().getTitle() + "\n"
                + "Нужно притвориться, что я делаю работу" + "\n"
                + "Пик, ПИК, пик. Что это вообще за задание такое?" + "\n"
                + "Закончил задание.");

        }
    }
}
