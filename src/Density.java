public class Density extends Attribute {
    
    // ..
    private Compound compound;
    private float value;

    public Density(String compound, float value) {
        this.compound = compound;
        this.value = value;
    }

    public String getCompound() {
        return compound;
    }

    public float getValue() {
        return value;
    }
}
