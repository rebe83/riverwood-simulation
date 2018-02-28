import java.util.List;
import java.util.ArrayList;

import Data.ItemType;
import Data.Litter;
import Data.Food;

public class Player {

    private final int MAX_HEALTH = 50;
    private final int MIN_ATTACK = 5;
    private final int MIN_DEFENSE = 5;

    private int health;
    private int attack;
    private int defense;
    private int cash;
    private Location currentLocation;
    private List<Item> inventory= new ArrayList<>();
    
    Player() {
        this.health = MAX_HEALTH;
        this.attack = MIN_ATTACK;
        this.defense = MIN_DEFENSE;
        this.cash = 0;
    }

    private boolean move() {
        return false;
    }

    private boolean attack(Animal animal) {
        animal.takeDamage(this.attack);
        return (animal.takeDamage(this.getAttack()));
    }

    public boolean takeDamage(int attack) {
        int previousHealth = this.health;
        int damage = attack - defense;
        this.health = this.health - damage;
        return (this.health < previousHealth);
    }

    private boolean feed(Animal animal, Item item) {
        if (item.getType() == ItemType.FOOD);
        for (Food a: animal.getFood()) {
            if (item.getName().equals(a.name())) {
                animal.eat(item);
            }
        }
        return false;
    }

    /**
     * the player picks up an item that is in the location.
     * @param item lowercase item
     */
    public boolean pickUpItem(Item item) {
        List<Item> roomItems = new ArrayList<>(currentLocation.getItems());
        for (Item a : roomItems) {
            if (a == item) {
                roomItems.remove(item);
                currentLocation.setItems(roomItems);
                inventory.add(a);
                return true;
            }
        }
        return false;
    }

    /**
     * the player drops an item
     * @param item proper cased item
     */
    public boolean dropItem(Item item) {
        List<Item> roomItems = new ArrayList<>(currentLocation.getItems());
        for (Item a : inventory) {
            if (a.getName().toLowerCase().equalsIgnoreCase(item.getName())) {
                roomItems.add(item);
                inventory.remove(a);
                return true;
            }
        }
        return false;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Simulation getSimulation() {
        return getCurrentLocation().getMap().getSimulation();
    }

    public Map getMap() {
        return getCurrentLocation().getMap();
    }

    public int getCash() {
        return cash;
    }
}
