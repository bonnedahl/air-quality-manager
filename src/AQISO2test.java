import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AQISO2test {
    @Test
    public void testAQIlevel10(){ //good
        Density d = new Density(Compound.SO2, 10);
        System.out.println("Test if value = 10, AQI = 14");
        assertEquals(14, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel50(){ //moderate
        Density d = new Density(Compound.SO2, 50);
        System.out.println("Test if value = 50, AQI = 69");
        assertEquals(69, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel100(){ //unhealthy for sensitive groups
        Density d = new Density(Compound.SO2, 100);
        System.out.println("Test if value = 100, AQI = 112");
        assertEquals(112, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel200(){ //unhealthy
        Density d = new Density(Compound.SO2, 200);
        System.out.println("Test if value = 200, AQI = 157");
        assertEquals(157, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel320(){ //very unhealthy
        Density d = new Density(Compound.SO2, 320);
        System.out.println("Test if value = 320, AQI = 206");
        assertEquals(206, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel700(){ //hazaradous
        Density d = new Density(Compound.SO2, 700);
        System.out.println("Test if value = 700, AQI = 348");
        assertEquals(348, d.getAQI(), 0);
    }
}
