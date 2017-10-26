package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;

    boolean alarmOn = false;
    ISensor sensor;

    public Alarm(ISensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        if (isPressureValueOutOfTheThreshold()) {
            alarmOn = true;
        }
    }

    private boolean isPressureValueOutOfTheThreshold(){
        double psiPressureValue = sensor.popNextPressurePsiValue();
        return psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
