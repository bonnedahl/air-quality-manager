import java.util.*;

public class AirQualityManager {
    // Main method
    public static void main(String[] args){
        System.out.println();
        CSVParser parser = new CSVParser("src/resources/data_10sensors_1year.csv");
        List<Measurement> model = parser.getMeasurements();
        new View(model);
    }
}

