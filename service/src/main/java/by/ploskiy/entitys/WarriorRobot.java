package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WarriorRobot extends BaseRobot {

    StringBuilder tmpStringBuilder = new StringBuilder();

    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION.toString())) {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + " 3 - 2 - 1 " + "\n"
                    + "Самоуничтожение... " + '\u2737');
//            taskController.removeRobotInList(getName());

            getTaskController().removeRobotInList(getName());

        } else if (getTask().getType().equals(TaskTypeEnum.KILL_ALL_HUMANS.toString())) {
            robotLogClearAll();
            tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + "Ломать! Крушить! От меня не спрятаться жалким людишкам!" + "\n"
                    + "OK Google, найди мне человеков!" + "\n");
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
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + "Я боевой робот, я могу только разрушать! " + "\n"
                    + "Задание отклонено");
        }
    }
}
