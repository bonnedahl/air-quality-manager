public class Density{
    
    // ..
    private final Compound compound;
    private final float value;
    private final double AQI;

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

    public double getAQI(){return AQI;}
}
