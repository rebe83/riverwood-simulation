import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    private static Simulation simulation;
    private static Map map;

    @Before
    public void setup() {
        simulation = new Simulation();
        map = new Map(simulation);
    }

    @Test
    public void randomIndex() {
        int randomInt = map.randomIndex(12);
        assertTrue(randomInt < 12 && randomInt >= 0);
        System.out.println(randomInt);
    }

    @Test
    public void manyRandoms() {
        int[] randoms = new int[1000];
        for (int i : randoms) {
            int a = map.randomIndex(1000);
            randoms[i] = a;
            System.out.println(randoms[i]);
            assertTrue(a < 1000 && a >= 0);
        }
    }

    //this is printing out no problems when conditions aren't met? did this for assertNotNull as well
    @Test
    public void getLocations() {
        assertTrue(map.getLocations() != null);
        System.out.println(map.getLocations()[0][0]);
    }

    @Test
    public void getWeather() {
        assertNotNull(map.getWeather());
        System.out.println(map.getWeather());
    }

    @Test
    public void getSeason() {
        assertNotNull(map.getSeason());
        System.out.println(map.getSeason());
    }

    @Test
    public void getNumBreeds() {
    }

    @Test
    public void getNumLitter() {
    }

    @Test
    public void getTotalAnimals() {
    }

    @Test
    public void getSimulation() {
    }
}