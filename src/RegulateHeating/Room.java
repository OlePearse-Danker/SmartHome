package RegulateHeating;

import java.util.concurrent.TimeUnit;

public abstract class Room {

    private double targetTemp, currentTemp;

    // template method
    public void regulateHeating() {
        long frequency = 60; // minutes

        while(heatingIsOn()) {

            changeFrequency();
            double change = (targetTemp - currentTemp) * (getRoomSize() / getPeopleNo());
            setHeatingTo(change);
            try {
                TimeUnit.MINUTES.sleep(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setHeatingTo(double change) {
        System.out.println("Heizung wird justiert auf: " + change);
    }

    // abstract methods
    public abstract boolean heatingIsOn();
    public abstract double getRoomSize();

    // hook method
    public void changeFrequency() {
        // do nothing
    }

    //default method
    public int getPeopleNo() {
        return 1;
    }
}
