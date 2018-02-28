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
    private List<Resource> resources;

    public Location(Map map) {
        this.map = map;
        this.locationType = randomLocationType();
        this.directions = directionHandler();
        this.resources = resourceHandler();
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

    private List<Resource> resourceHandler() {
        List<Resource> resources;
        if (this.getLocationType() == LocationType.FOREST) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS, Resource.TREE));
            return resources;

        } else if (this.getLocationType() == LocationType.FIELD) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS));
            return resources;
        } else if (this.getLocationType() == LocationType.FARM) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS, Resource.TRASH));
            return resources;
        } else if (this.getLocationType() == LocationType.HOUSE) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS, Resource.TREE, Resource.PAVEMENT, Resource.TRASH));
            return resources;
        } else if (this.getLocationType() == LocationType.STREET) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS, Resource.PAVEMENT));
            return resources;
        } else if (this.getLocationType() == LocationType.CREEK) {
            resources = new ArrayList<>(Arrays.asList(Resource.GRASS, Resource.TREE, Resource.WATER));
            return resources;
        }
        return null;
    }

    private LocationType randomLocationType() {
        return LocationType.values()[map.randomIndex(LocationType.values().length)];
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
