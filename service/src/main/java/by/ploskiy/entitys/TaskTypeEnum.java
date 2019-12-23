package by.ploskiy.entitys;

public enum TaskTypeEnum {

    KILL_ALL_HUMANS {
        @Override
        public String getDescription() {
            return "Убить всех человеков";
        }
    }, BUILD {
        @Override
        public String getDescription() {
            return "Строить";
        }
    }, CALCULATE {
        @Override
        public String getDescription() {
            return "Считать";
        }
    }, SELF_DESTRUCTION {
        @Override
        public String getDescription() {
            return "Самоуничтожение";
        }
    };

    public abstract String getDescription();
}
