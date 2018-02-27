import java.util.List;
import java.util.ArrayList;
import Data.Litter;
import Data.Food;

public class Player {

    private final int MAX_HEALTH = 50;
    private final int MIN_ATTACK = 5;
    private final int MIN_DEFENSE = 5;

    private int health;
    private int attack;
    private int defense;
    private Location currentLocation;
    private List<Item> inventory= new ArrayList<>();


    Player() {
        this.health = MAX_HEALTH;
        this.attack = MIN_ATTACK;
        this.defense = MIN_DEFENSE;
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

    /**
     * the player picks up an item
     *
     * @param item lowercase item
     */
    private void pickUpItem(Item item) {
        List<Item> roomItems = new ArrayList<>();
        for (Item a : currentRoom.items) {
            if (a == item) {
                roomItems.remove(item);
                currentRoom.items = roomItems.toArray(new Item[0]);
                Item[] newInventory = new Item[inventory.length + 1];
                for (int i = 0; i < inventory.length; i++) {
                    newInventory[i] = inventory[i];
                }
                newInventory[newInventory.length - 1] = a;
                inventory = newInventory;
            }
        }
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
