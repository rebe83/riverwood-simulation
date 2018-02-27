import java.util.List;
import java.util.ArrayList;
import Data.LocationType;
import Data.AnimalBreed;
import Data.Resource;
import Data.Litter;

public class Location {

    private Map map;
    private LocationType locationType;
    private List<Animal> animals = new ArrayList<>();
    private List<Litter> litter = new ArrayList<>();
    private List<Resource> resources = new ArrayList<>();

    public boolean addAnimal(AnimalBreed type) {
        this.animals.add(new Animal(type));
        return true;
    }

    public boolean useResource(Resource resource) {
        return false;
    }
}
