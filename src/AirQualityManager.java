public class AirQualityManager {
    // Main method
    public static void main(String[] args) {
        //SensorDataPoint measurement = new SensorDataPoint(GasLabel.NO2, ) ;
        //String test = Compound.O3.getUnit();

        //Parser p = new Parser("./resources/data_10senors_1year.csv");
        //List model = p.getModel();
        //View gui = new View(model);

        Density d = new Density(Compound.NO2, 1500);
        System.out.println("NO2 1500 = " + d.getAQILevel());
    }
}
