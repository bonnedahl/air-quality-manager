import java.util.*;

public class Measurement {

    private Calendar timestamp;
    private Sensor sensor;
    private Density[] values;

    // We assume, that a sensor always measures the 4 different gases at the same time

    public Measurement(Calendar timestamp, Sensor sensor, Density[] values) {
        this.timestamp = timestamp;
        this.sensor = sensor;
        this.values = values;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }
    public Sensor getSensor() {
        return sensor;
    }
    public Density[] getValues() {
        return values;
    }
}
