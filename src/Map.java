import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import Data.*;

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

    private boolean animalMaker() {
        if (this.locations != null) {
            while (totalAnimals < 20) {
                for (int i = 0; i < locations.length; i++) {
                    for (int j = 0; j < locations[i].length; j++) {
                        while(locations[i][j].getAnimals().size() < 5 ) {
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

    private Weather randomWeather() {
        return Weather.values()[randomIndex(Weather.values().length)];
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

}
