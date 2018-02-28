import Data.LocationType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    Map map;
    Location location;

    private LocationType randomLocationType() {
        return LocationType.values()[map.randomIndex(LocationType.values().length)];
    }

    @Before
    public void setup() {
        map = new Map();
        location = new Location(map);
    }

    @Test
    public void addAnimal() {
    }

    @Test
    public void getAnimal() {
    }

    @Test
    public void randomLocationNotNullTest() {
        assertTrue(null != randomLocationType());
    }

    @Test
    public void getLocationType() {
        assertTrue(location.getLocationType() != null);
    }

    @Test
    public void setLocationType() {
        location.setLocationType(LocationType.CREEK);
        assertTrue(LocationType.CREEK == location.getLocationType());
    }

    @Test
    public void getMap() {
    }

    @Test
    public void getCoordinate() {
    }

    @Test
    public void setCoordinate() {
    }
}