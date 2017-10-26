package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    public static final double PRESSURE_VALUE_BEYOND_THE_THRESHOLD = 22;
    public static final double PRESSURE_VALUE_UNDER_THE_THRESHOLD = 16;
    public static final double PRESSURE_VALUE_INSIDE_THE_THRESHOLD = 18;

    @Test
    public void testCheckAlarmOnWithSensorValueBeyondTheThreshold(){
        Alarm alarm = new Alarm(sensorThatReturnsAPressureValueBeyondTheThreshold);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void testCheckAlarmOnWithSensorValueUnderTheThreshold(){
        Alarm alarm = new Alarm(sensorThatReturnsAPressureValueUnderTheThreshold);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void testCheckAlarmOnWithSensorValueInsideTheThreshold(){
        Alarm alarm = new Alarm(sensorThatReturnsAPressureValueInsideTheThreshold);
        alarm.check();
        assertEquals(false, alarm.isAlarmOn());
    }

    ISensor sensorThatReturnsAPressureValueBeyondTheThreshold = new ISensor() {
        @Override
        public double popNextPressurePsiValue() {
            return PRESSURE_VALUE_BEYOND_THE_THRESHOLD;
        }
    };

    ISensor sensorThatReturnsAPressureValueInsideTheThreshold = new ISensor() {
        @Override
        public double popNextPressurePsiValue() {
            return PRESSURE_VALUE_INSIDE_THE_THRESHOLD;
        }
    };

    ISensor sensorThatReturnsAPressureValueUnderTheThreshold = new ISensor() {
        @Override
        public double popNextPressurePsiValue() {
            return PRESSURE_VALUE_UNDER_THE_THRESHOLD;
        }
    };
}
