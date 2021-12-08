import com.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    List<Measurement> measurements;
    public CSVParser(String filename){
        measurements = extractMeasurements(filename);
    }
    public List<Measurement> getMeasurements() {
        return measurements;
    }

    // CSV Parser
    private static List<Measurement> extractMeasurements(String filename) {
        int i = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        List<Measurement> res = new ArrayList<Measurement>();
        List<String> test = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filename, Charset.forName("utf-16")))) {
            String[] line;
            Density[] densities = new Density[4];
            while ((line = reader.readNext()) != null) {
                String lineAsString = line[0];
                test.add(lineAsString);
                // Skip the first row
                if(i++ == 0) {
                    continue;
                }
                String[] parts = lineAsString.split(";");


                // We use build densities, then we build the entire measuring of 4
                densities[(i-2)%4] = new Density(Compound.valueOf(parts[2]), Float.parseFloat(parts[3]));
                // We construct a measurement object at every 4th row
                if((i-1)%4 == 0) {
                    res.add(new Measurement(dateFormat.parse(parts[0]), Sensor.valueOf(parts[1]), densities));
                    densities = new Density[4];
                }
            }
        } catch(Exception e){}
        return res;
    }
}
