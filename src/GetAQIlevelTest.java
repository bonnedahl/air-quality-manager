import static org.junit.Assert.*;
import org.junit.Test;

public class GetAQIlevelTest {

    @Test
    public void testGetAQIlevelGood(){
        System.out.println("Test if 0 < AQI < 50 = Good");
        Density good = new Density(Compound.NO2, 10);
        assertEquals("Good", good.getAQILevel(good.getAQI()));
    }
    @Test
    public void testGetAQIlevelModerate(){
        System.out.println("Test if 51 < AQI < 100 = Moderate");
        Density moderate = new Density(Compound.NO2, 90);
        assertEquals("Moderate", moderate.getAQILevel(moderate.getAQI()));
    }
    @Test
    public void testGetAQIlevelUnealthySensitive(){
        System.out.println("Test if 101 < AQI < 150 = Unhealthy for Sensitive Groups");
        Density unhealthySensitive = new Density(Compound.NO2, 250);
        assertEquals("Unhealthy for Sensitive Groups", unhealthySensitive.getAQILevel(unhealthySensitive.getAQI()));
    }
    @Test
    public void testGetAQIlevelUnhealthy(){
        System.out.println("Test if 151 < AQI < 200 = Unhealthy");
        Density unhealthy = new Density(Compound.NO2, 550);
        assertEquals("Unhealthy", unhealthy.getAQILevel(unhealthy.getAQI()));
    }
    @Test
    public void testGetAQIlevelVUnhealthy(){
        System.out.println("Test if 201 < AQI < 300 = Very Unhealthy");
        Density vUnhealthy = new Density(Compound.NO2, 700);
        assertEquals("Very Unhealthy", vUnhealthy.getAQILevel(vUnhealthy.getAQI()));
    }
    @Test
    public void testGetAQIlevelHazardous(){
        System.out.println("Test if AQI > 301 = Hazardous");
        Density hazardous = new Density(Compound.NO2, 1500);
        assertEquals("Hazardous", hazardous.getAQILevel(hazardous.getAQI()));
    }
}
