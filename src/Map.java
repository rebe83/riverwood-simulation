import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import Data.*;

/**
 * The Map class creates a square grid of locations, populates it with animals and litter,
 * and holds on to weather and season information,
 * as well as how many in-game months have passed since the map was generated.
 */
public class Map {
    /**
     * the maximum amount of animals allowed on the map
     */
    private static final int MAX_ANIMALS = 50;
    private static final int MAX_LITTER = 30;
    private static final int MAX_ONE_BREED = 10;

    private Location[][] locations;
    private Weather weather;
    private int months;
    private Season season;
    private int[] numBreeds;
    private int totalAnimals;
    private int numLitter;

    Map() {
        locations = new Location[4][4];
        numBreeds = new int[AnimalBreed.values().length];
        numLitter = randomIndex(20) + 11;
        weather = randomWeather();
        season = randomSeason();
        months = 0;
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(this);
                locations[i][j].setCoordinate(i * 10 + j);
            }
        }
        animalMaker();
        litterMaker();
    }

    /**
     * Uses the randomIndex method to randomly create animals to populate each location, up to 5/ location,
     * during map creation
     * @return if the creation worked up to specifications.
     */
    private boolean animalMaker() {
        if (this.locations != null) {
            while (totalAnimals < 20) {
                for (int i = 0; i < locations.length; i++) {
                    for (int j = 0; j < locations[i].length; j++) {
                        while(locations[i][j].getNumAnimals() < 5 ) {
                            for (int k = 0; k < this.randomIndex(5); k++) {
                                Animal newAnimal = new Animal(locations[i][j]);

                                if (numBreeds[newAnimal.getBreed().ordinal()] + 1 > MAX_ONE_BREED) {
                                    k++;
                                } else {
                                    locations[i][j].addAnimal(newAnimal);
                                    totalAnimals++;
                                    numBreeds[newAnimal.getBreed().ordinal()]++;
                                }

                            }
                        }
                    }
                }
            }
        }
        return (totalAnimals >= 20);
    }

    /**
     * Uses the randomIndex method to randomly create litter to populate each location, up to 2 / location,
     * during map creation.
     * @return if the creation worked up to specifications.
     */
    private boolean litterMaker() {
        if (this.locations != null) {
            while (numLitter < MAX_LITTER) {
                for (int i = 0; i < locations.length; i++) {
                    for (int j = 0; j < locations[i].length; j++) {
                        while(locations[i][j].getItems().size() < 2 ) {
                            for (int k = 0; k < this.randomIndex(3); k++) {
                                List<Item> newItems = locations[i][j].getItems();
                                newItems.add(new Item(Litter.values()[randomIndex(Litter.values().length)]));
                                locations[i][j].setItems(newItems);
                                numLitter++;
                            }
                        }
                    }
                }
            }
        }
        return (numLitter >= MAX_LITTER);
    }

    /**
     * chooses a random index of an array based on its length (or a random number within a value)
     * @param arrayLength the length of the array
     * @return the chosen index / randomized number.
     */
    public int randomIndex(int arrayLength) {
        Random random = new Random();
        return random.nextInt(arrayLength - 1);
    }

    private Weather randomWeather() {
        return Weather.values()[randomIndex(Weather.values().length)];
    }

    private Season randomSeason() {
        return Season.values()[randomIndex(Season.values().length)];
    }

    public int getMaxAnimals() {
        return MAX_ANIMALS;
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

}
