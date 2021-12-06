import java.util.*;

public class Measurement {

    private Date timestamp;
    private Sensor sensor;
    private Density[] values;

    // We assume, that a sensor always measures the 4 different gases at the same time

    public Measurement(Date timestamp, Sensor sensor, Density[] values) {
        this.timestamp = timestamp;
        this.sensor = sensor;
        this.values = values;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Density[] getValues() {
        return values;
    }
}
