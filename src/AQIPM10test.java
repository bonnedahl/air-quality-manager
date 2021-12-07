import static org.junit.Assert.*;
import org.junit.Test;

public class AQIPM10test {
    @Test //good
    public void testAQIlevel10(){
        Density d = new Density(Compound.PM10, 10);
        System.out.println("Test if value = 10, AQI = 9");
        assertEquals(9, d.getAQI(), 0);
    }
    @Test //moderate
    public void testAQIlevel60(){
        Density d = new Density(Compound.PM10, 60);
        System.out.println("Test if value = 60, AQI = 53");
        assertEquals(53, d.getAQI(), 0);
    }
    @Test //unhealthy for sensitive groups
    public void testAQIlevel170(){
        Density d = new Density(Compound.PM10, 170);
        System.out.println("Test if value = 170, AQI = 108");
        assertEquals(108, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel300(){ //unhealthy
        Density d = new Density(Compound.PM10, 300);
        System.out.println("Test if value = 300, AQI = 173");
        assertEquals(173, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel400(){ //very unhealthy
        Density d = new Density(Compound.PM10, 400);
        System.out.println("Test if value = 400, AQI = 266");
        assertEquals(266, d.getAQI(), 0);
    }
    @Test
    public void testAQIlevel500(){ //hazardous
        Density d = new Density(Compound.PM10, 500);
        System.out.println("Test if value = 500, AQI = 395");
        assertEquals(395, d.getAQI(), 0);
    }
}

