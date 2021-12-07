import static org.junit.Assert.*;
import org.junit.Test;

public class AQINO2Test {
    @Test
    public void testNO2AQIlevel10(){ //good
        Density d = new Density(Compound.NO2, 10);
        System.out.println("Test if value = 10, AQI = 9");
        assertEquals(9, d.getAQI(), 0);
    }
    @Test
    public void testNO2AQIlevel90(){ //moderate
        Density d = new Density(Compound.NO2, 90);
        System.out.println("Test if value = 90, AQI = 89");
        assertEquals(89, d.getAQI(), 0);
    }
    @Test
    public void testNO2AQIlevel250(){ //unhealthy for sensitive groups
        Density d = new Density(Compound.NO2, 250);
        System.out.println("Test if value = 250, AQI = 129");
        assertEquals(129, d.getAQI(), 0);
    }
    @Test
    public void testNO2AQIlevel550(){ //unhealthy
        Density d = new Density(Compound.NO2, 550);
        System.out.println("Test if value = 550, AQI = 183");
        assertEquals(183, d.getAQI(), 0);
    }
    @Test
    public void testNO2AQIlevel700(){ //very unhealthy
        Density d = new Density(Compound.NO2, 700);
        System.out.println("Test if value = 700, AQI = 209");
        assertEquals(209, d.getAQI(), 0);
    }
    @Test
    public void testNO2AQIlevel1500(){ //hazardous
        Density d = new Density(Compound.NO2, 1500);
        System.out.println("Test if value = 1500, AQI = 363");
        assertEquals(363, d.getAQI(), 0);
    }
}
