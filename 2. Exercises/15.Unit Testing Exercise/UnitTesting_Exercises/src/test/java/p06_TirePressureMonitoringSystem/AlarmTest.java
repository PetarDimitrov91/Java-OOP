package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void testChekMethodIfIsLowPressureReturnsTrue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testChekMethodIfIsHighPressureReturnsTrue() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.2);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testChekMethodIfIsNormalPressureReturnsFalse() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.00);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }


}
