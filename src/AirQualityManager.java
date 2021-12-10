import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class AirQualityManager {
    // Main method
    public static void main(String[] args){
        System.out.println();
        FileReader r;
        try{
            r = new FileReader("src/resources/data_10sensors_1year.csv", Charset.forName("utf-16"));
        } catch (IOException e) {
            try {
                r = new FileReader("data_10sensors_1year.csv", Charset.forName("utf-16"));
            } catch (IOException ex) {
                System.err.println("Can't find data-file. Make sure data_10sensors_1year.csv is in the same directory as your jar!");
                return;
            }
        }
        CSVParser parser = new CSVParser(r);
        List<Measurement> model = parser.getMeasurements();
        new View(model);
    }
}

