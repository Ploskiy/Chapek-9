package by.ploskiy.entitys;

import by.ploskiy.services.TaskController;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleRobot extends BaseRobot {

    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION.toString())) {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + " 3 - 2 - 1 " + "\n"
                    + "Самоуничтожение... " + '\u2737');

        } else if (getTask().getType().equals(TaskTypeEnum.KILL_ALL_HUMANS.toString())) {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + "Ура! Охота на человеков!" + "\n"
                    + "Поиск человеков..." + "\n"
                    + "Простой робот провалил задание");
        } else {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + "Делаю..." + "\n"
                    + "[==========] 100%" + "\n"
                    + "Закончил задание.");
        }
    }
}
