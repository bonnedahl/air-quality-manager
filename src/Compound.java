import java.util.function.DoubleFunction;

public enum Compound {
    O3("Âµg/m3", "ozone content", Compound::calcO3AQI),
    SO2("Âµg/m3", "sulfur dioxide content", Compound::calcSO2AQI),
    NO2("Âµg/m3", "nitrogen dioxide content", Compound::calcNO3AQI),
    PM10("Âµg/m3","fine particles content", Compound::calcPM10AQI);

    private final String unit;
    private final String description;
    private final DoubleFunction function;

    private static double calcO3AQI(double v){
        if(v > 100){
            return 10;
        }else{
            return 0;
        }
    }
    private static double calcSO2AQI(double v){
        if(v > 100){
            return 10;
        }else{
            return 0;
        }
    }
    private static double calcNO3AQI(double v){
        if(v > 100){
            return 10;
        }else{
            return 0;
        }
    }
    private static double calcPM10AQI(double v){
        if(v > 100){
            return 10;
        }else{
            return 0;
        }
    }


    Compound(String unit, String description, DoubleFunction m) {
        this.unit = unit;
        this.description = description;
        this.function = m;
    }

    public String getUnit() { return unit; }
    public String getDescription() { return description; }
    public DoubleFunction getFunction(){return function;}


}