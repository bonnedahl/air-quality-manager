import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AirQualityManager {
    // Main method
    public static void main(String[] args){


    }

    // CSV Parser
    public static List<Measurement> extractMeasurements(String filename) {
        int i = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");
        List<Measurement> res = new ArrayList<Measurement>();
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] line;
            while ((line = reader.readNext()) != null) {

                // Skip the first row
                if(i == 0) {
                    continue;
                }

                // We use build densities, then we build the entire measuring of 4
                Density[] densities = new Density[4];
                densities[(i-1)%4] = new Density(Compound.valueOf(line[2]), Float.parseFloat(line[3]));
                
                // We construct a measurement object at every 4th row
                if(i%4 == 0) {
                    //Date date = dateFormat.parse(line[0]);
                    res.add(new Measurement(dateFormat.parse(line[0]), Sensor.valueOf(line[1]), densities));
                }
            }
        } catch(Exception e){}

        return res;
    }

}

