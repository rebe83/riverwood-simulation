import java.util.List;
import java.util.ArrayList;

import Data.LocationType;
import Data.Weather;

public class Map {


    private Location[][] MAP = new Location[5][5];
    private Weather weather;
    private int NUM_ANIMALS;
    private int NUM_LITTER;

    public Weather randomWeather() {
        Weather[] weathers = Weather.values();
        return weathers[0];
    }

    public LocationType randomLocationType() {
        return LocationType.value();
    }
}
