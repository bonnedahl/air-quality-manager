import static org.junit.Assert.*;
import org.junit.Test;

public class AQIO3test {
    @Test
    public void testAQIlevel10(){ //good
        Density d = new Density(Compound.O3, 10);
        System.out.println("Test if value = 10, AQI = 9");
        assertEquals(9, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel60(){ //moderate
        Density d = new Density(Compound.O3, 60);
        System.out.println("Test if value = 60, AQI = 67");
        assertEquals(67, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel80(){ //unhealthy for sensitive groups
        Density d = new Density(Compound.O3, 80);
        System.out.println("Test if value = 80, AQI = 133");
        assertEquals(133, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel100(){ //unhealthy
        Density d = new Density(Compound.O3, 100);
        System.out.println("Test if value = 100, AQI = 187");
        assertEquals(187, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel120(){ //very unhealthy
        Density d = new Density(Compound.O3, 120);
        System.out.println("Test if value = 120, AQI = 216");
        assertEquals(216, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel450(){ //hazardous
        Density d = new Density(Compound.O3, 450);
        System.out.println("Test if value = 450, AQI = 346");
        assertEquals(346, d.getAQI(), 0);
    }


}
