class Sensor {
    
    private String id, description;
    private float lat, lon; 

    public Sensor(String id, String description, float lat, float lon) {
        this.id = id;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public float[] getCoordinates() {
        float[] coordinates = new float[2];
        coordinates[0] = this.lat;  // latitude
        coordinates[1] = this.lon;  // longitude
        return coordinates;
    }
}