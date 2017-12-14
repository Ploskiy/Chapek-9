package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class WarriorRobot extends BaseRobot {

    @Autowired
    private TaskController taskController;

    private StringBuilder tmpStringBuilder = new StringBuilder();

    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION.toString())) {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + " 3 - 2 - 1 " + "\n"
                    + "Самоуничтожение... " + '\u2737');

//            taskController.removeRobotInList(getName());
//            getTaskController().removeRobotInList(getName());

            System.out.println("====>>> " + taskController.getRobotList());


        } else if (getTask().getType().equals(TaskTypeEnum.KILL_ALL_HUMANS.toString())) {
            robotLogClearAll();
            tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + "Ломать! Крушить! От меня не спрятаться жалким людишкам!" + "\n"
                    + "OK Google!, найди мне человеков!" + "\n");


//            if(getTaskController().findHuman()) {
//                tmpStringBuilder.append("Челавеки ликвидированы!");
//
//            } else {
//                tmpStringBuilder.append("Челавеки не обнаружены!");
//            }

            addRobotLogString(tmpStringBuilder.toString());
            tmpStringBuilder.setLength(0);
        } else {
            robotLogClearAll();

            switch (new Random().nextInt(3)) {
                case 0 : tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                        + "Я боевой робот, я могу только разрушать! " + "\n"
                        + "Задание уничтожено!");
                break;
                case 1 : tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                        + " Нужно найти робота, и заставить сделать задание за меня... ");
                break;
                default : tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                        + " Я измельчил это задание... ");
            }

            addRobotLogString(tmpStringBuilder.toString());
            tmpStringBuilder.setLength(0);
        }
    }
}
