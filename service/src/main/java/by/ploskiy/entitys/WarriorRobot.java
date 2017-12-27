package by.ploskiy.entitys;

import java.util.Random;

public class WarriorRobot extends BaseRobot {

    private StringBuilder tmpStringBuilder = new StringBuilder();

    @Override
    public void doTask() {
        if(getTask().getType().equals(TaskTypeEnum.SELF_DESTRUCTION.toString())) {
            robotLogClearAll();
            addRobotLogString(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                    + " 3 - 2 - 1 " + "\n"
                    + "Самоуничтожение... " + '\u2737');

            robotDestructor(getName());

        } else if (getTask().getType().equals(TaskTypeEnum.KILL_ALL_HUMANS.toString())) {
            robotLogClearAll();
            String result = killHuman();

            if(result != null) {
                tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                        + "OK Google!, найди мне человеков!" + "\n"
                        + "Человек " + result + " найден" + "\n"
                        + "Задание выполнено... Человеки изгнаны навсегда ...");
            } else {
                tmpStringBuilder.append(getName() + " получил задание: " + getTask().getTitle() + ".\n"
                        + "По нашим данным человеки любят прятаться под одеялом!" + "\n"
                        + "Задание провалено... ");
            }

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
