package by.ploskiy.entitys;

public enum TaskEnum {

    HEAD {
        @Override
        public String getDescription() {
            return "Голова";
        }
    }, BODY {
        @Override
        public String getDescription() {
            return "Тело";
        }
    }, LEFT_HAND {
        @Override
        public String getDescription() {
            return "Левая рука";
        }
    };

    public abstract String getDescription();
}
