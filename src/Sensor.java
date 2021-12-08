public enum Sensor {

    Sensor0(0,-8.15758888291083,-34.7692487876719, "South Atlantic Ocean"),
    Sensor1(1,-30.0647387677174, -76.3439147576429, "South Pacific Ocean"),
    Sensor2(2, 38.9221784071634, -89.2363721594384, "Illinois"),
    Sensor3(3, -5.92154786033628, 75.2608366614491, "Indian Ocean" ),
    Sensor4(4, -10.0514503172838, 87.5506518210986, "Indian Ocean"),
    Sensor5(5, 11.8876924118435, 67.0476760328969, "Arabian Sea"),
    Sensor6(6, -23.6333200096308, -71.2536555348214, "South Pacific Ocean"),
    Sensor7(7, 16.3216940040335, -86.1531723924694, "Caribbean Sea"),
    Sensor8(8, -4.1832184228968, 52.6153151610006, "Indian Ocean"),
    Sensor9(9, 36.2756694672982, 1.33005024461543, "Algeria");

    private final int SensorID;
    private final Double longitude;
    private final Double latitude;
    private final String location;

    private Sensor(int SensorID, double longitude, double latitude, String location){
        this.SensorID = SensorID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.location = location;
    }

    public int getSensorID() { return SensorID; }
    public Double getLongitude() { return longitude; }
    public Double getLatitude() { return latitude; }
    public String getLocation() { return location; }
}

