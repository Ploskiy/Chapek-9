package by.ploskiy.entitys;

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

    public void run() {
//        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());

        if (getTask() != null){
            doTask();
            System.out.println(getRobotLog());
            setTask(null);
        }
//        System.out.printf("Поток %s закончил работу... \n", Thread.currentThread().getName());
    }

    private String loadProcess(){
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i <= 10; i++){
            for (int l = 0; l < i; l++) {
                stringBuilder.append("=");
            }
            stringBuilder.append("").append(i * 10).append("%");

            robotLogRemoveLastString();
//            addRobotLogString(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        return stringBuilder.toString();
    }
}
