
public class Density {

    // ..
    private final Compound compound;
    private final float value;
    private final double AQI;

    public Density(Compound compound, float value) {
        this.compound = compound;
        this.value = value;
        this.AQI = (double)compound.getFunction().apply(value);
    }

    public double getAQI() { return AQI; }
    public float getValue() { return value; }
    public Compound getCompound() { return compound; }

    // https://www.airnow.gov/aqi/aqi-basics/
    public String getAQILevel(){
       if(0 < AQI && AQI <= 50)
           return("Good");
       else if(51 < AQI && AQI <=100)
           return("Moderate");
       else if(101 < AQI && AQI <= 150)
           return("Unhealthy for Sensitive Groups");
       else if(151 < AQI && AQI <= 200)
           return("Unhealthy");
       else if(201 < AQI && AQI <= 300)
           return("Very Unhealthy");
       else if(301 < AQI && AQI <= 500)
           return("Hazardous");
    return("Unable to get AQI Level");
    }

    public static String getAQILevel(double AQI){
        if(0 < AQI && AQI <= 50)
            return("Good");
        else if(51 < AQI && AQI <=100)
            return("Moderate");
        else if(101 < AQI && AQI <= 150)
            return("Unhealthy for Sensitive Groups");
        else if(151 < AQI && AQI <= 200)
            return("Unhealthy");
        else if(201 < AQI && AQI <= 300)
            return("Very Unhealthy");
        else if(301 < AQI && AQI <= 500)
            return("Hazardous");
        return("Unable to get AQI Level");
    }
}