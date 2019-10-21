package ru.sbt.mipt.oop;

public class Devise implements ComponentOfTheCollection {
        private boolean someAct;
        private final String id;

        public Devise(String id, boolean someAct) {
            this.id = id;
            this.someAct = someAct;
        }

        public boolean isSomeAct() {
            return someAct;
        }

        public String getId() {
            return id;
        }

        public void setOn(boolean on) {
            someAct = on;
        }

    @Override
    public void execute(SensorEvent event) {
        if (this.id.equals(event.getObjectId())) {

        }
    }
}
