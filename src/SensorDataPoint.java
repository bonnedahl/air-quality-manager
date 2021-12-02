import java.util.Date;

public class SensorDataPoint {
   // private final Date time;
    private String time;
    private GasLabel compound;
    private String sensorID;
    private double value;

    public SensorDataPoint(GasLabel compound, String time, String sensorID, double value){
        this.compound = compound;
        this.time = time;
        this.sensorID = sensorID;
        this.value = value;
    }
    public GasLabel getCompound(){ return this.compound; }
    public String getTime() { return time;  }
    public String getSensorID() { return sensorID; }
    public double getValue() { return value; }
}
