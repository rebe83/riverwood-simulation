import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import Data.*;

public class Map {
    /**
     * the maximum amount of animals allowed on the map
     */
    private static final int MAX_ANIMALS = 50;

    private Simulation simulation;
    private Location[][] locations;
    private Weather weather;
    private int months;
    private Season season;
    private int[] numBreeds;
    private int totalAnimals;
    private int numLitter;

    Map(Simulation simulation) {
        this.simulation = simulation;
        locations =  new Location[4][4];
        numBreeds = new int[AnimalBreed.values().length];
        numLitter = randomIndex(20) + 11;
        weather = randomWeather();
        season = randomSeason();
        months = 0;
    }

    private Weather randomWeather() {
        return Weather.values()[randomIndex(Weather.values().length)];
    }

    private LocationType randomLocationType() {
        return LocationType.values()[randomIndex(LocationType.values().length)];
    }

    private Season randomSeason() {
        return Season.values()[randomIndex(Season.values().length)];
    }

    public int randomIndex(int arrayLength) {
        Random random = new Random();
        return random.nextInt(arrayLength - 1);
    }

    public Location[][] getLocations() {
        return locations;
    }

    public Weather getWeather() {
        return weather;
    }

    public int getMonths() {
        return months;
    }

    public Season getSeason() {
        return season;
    }

    public int[] getNumBreeds() {
        return numBreeds;
    }

    public int getNumLitter() {
        return numLitter;
    }

    public int getTotalAnimals() {
        return totalAnimals;
    }

    public Simulation getSimulation() {
        return simulation;
    }
}
