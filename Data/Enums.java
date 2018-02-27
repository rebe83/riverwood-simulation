public class Enums {

    enum Weather {SUN, CLOUD, WIND, RAIN, STORM, FLOOD, DROUGHT, SNOW, HAIL}
    enum LocationType {FOREST, FIELD, FARM, HOUSE, STREET, CREEK}
    enum Resource {WATER, GRASS, TREES, TRASH, PAVEMENT}
    enum AnimalType {FOX, SNAKE, BEAVER, RACCOON, DEER, POSSUM, MOUSE, SQUIRREL, CARDINAL, SPARROW, OWL, HAWK, COUGAR, COYOTE}

    public Weather randomWeather() {
        return Weather.value();
    }

    public LocationType randomLocationType() {
        return LocationType.value();
    }

    public Resources randomResource() {
        return Resources.values();
    }

    public AnimalType randomAnimalType() {
        return AnimalType.values();
    }

}
