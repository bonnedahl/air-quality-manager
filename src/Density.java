import java.util.concurrent.CopyOnWriteArrayList;

public class Density {
    
    // ..
    private Compound compound;
    private float value;
    //float AQI
    //if its 03 then this calculation

    public Density(Compound compound, float value) {
        this.compound = compound;
        this.value = value;
        this.AQI = (double) compound.getFunction().apply(value);
    }

    public Compound getCompound() {
        return compound;
    }

    public float getValue() {
        return value;
    }

    public float calcAQI(Compound compound, float value){
        if(compound == Compound.NO2)
            return value - 2;
        return 0;
    }
}
