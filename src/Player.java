import java.util.List;
import java.util.ArrayList;
import Data.Litter;
import Data.Food;

public class Player {

    private int MAX_HEALTH = 50;
    private int health;
    private Location currentLocation;
    private int defense;
    private List<Item> inventory= new ArrayList<>();


    Player() {

    }

    private boolean move() {
        return false;
    }

    private boolean attack(Animal animal) {
        return false;
    }

    private boolean feed(Animal animal) {
        return false;
    }


}
