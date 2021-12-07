<<<<<<< HEAD
import java.util.concurrent.CopyOnWriteArrayList;

public class Density {
    
    // ..
    private Compound compound;
    private float value;
    //float AQI
    //if its 03 then this calculation
=======
public class Density {

    // ..
    private final Compound compound;
    private final float value;
    private final double AQI;
>>>>>>> 6c3286de4d6156be0608adc1b998e1f648745f6a

    public Density(Compound compound, float value) {
        this.compound = compound;
        this.value = value;
        this.AQI = (double)compound.getFunction().apply(value);
    }

    public double getAQI() { return AQI; }
    public float getValue() { return value; }
    public Compound getCompound() { return compound; }


<<<<<<< HEAD
    public float calcAQI(Compound compound, float value){
        if(compound == Compound.NO2)
            return value - 2;
        return 0;
    }
}
=======
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
}
>>>>>>> 6c3286de4d6156be0608adc1b998e1f648745f6a
