import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import Data.*;

public class Location {

    private Map map;
    private int coordinate;
    private List<Direction> directions;
    private LocationType locationType;
    private List<Animal> animals = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Resource> resources = new ArrayList<>();

    public Location() {
        this.directions = directionHandler();
    }

    public boolean addAnimal(Animal animal) {
        this.animals.add(animal);
        return true;
    }

    private boolean removeAnimal(Animal animal) {
        this.animals.remove(animal);
        this.resources.add(Resource.DEAD_ANIMAL);
        return false;
    }

    public Animal getAnimal(String animalName) {
        for (Animal a : this.animals) {
            if (a.getBreed().name().equalsIgnoreCase(animalName)) {
                return a;
            }
        }
        return null;
    }

    private List<Direction> directionHandler() {
        List<Direction> directions = new ArrayList<>(Arrays.asList(Direction.values()));
        if(this.coordinate % 10 == 0) {
            directions.remove(Direction.WEST);
        }
        if (this.coordinate % 10 == 3) {
            directions.remove(Direction.EAST);
        }
        if (this.coordinate / 10 < 1) {
            directions.remove(Direction.NORTH);
        }
        if (this.coordinate / 30 >= 1) {
            directions.remove(Direction.SOUTH);
        }
        return directions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
