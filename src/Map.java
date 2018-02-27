import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import Data.*;

public class Map {
    private Location[][] map;
    private Weather weather;
    private int months;
    private Season season;
    private int[] numAnimals;
    private int numLitter;

    Map() {
        map =  new Location[5][5];

    }

    public Weather randomWeather() {
        Weather[] weathers = Weather.values();
        return weathers[randomIndex(weathers.length)];
    }

    public LocationType randomLocationType() {
        LocationType[] locationTypes = LocationType.values();
        return locationTypes[randomIndex(locationTypes.length)];
    }

    public int randomIndex(int arrayLength) {
        Random random = new Random();
        return random.nextInt(arrayLength - 1);
    }
}
