import java.util.concurrent.CopyOnWriteArrayList;

public class Density extends Attribute {
    
    // ..
    private Compound compound;
    private float value;

    public Density(Compound compound, float value) {
        this.compound = compound;
        this.value = value;
    }

    public Compound getCompound() {
        return compound;
    }

    public float getValue() {
        return value;
    }
}
