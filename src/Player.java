import java.util.List;
import java.util.ArrayList;
import Data.Litter;
import Data.Food;

public class Player {

    private final int MAX_HEALTH = 50;
    private final int MIN_ATTACK = 5;
    private final int MIN_DEFENSE = 5;

    private Map map;
    private int health;
    private int attack;
    private int defense;
    private int cash;
    private Location currentLocation;
    private List<Item> inventory= new ArrayList<>();
    
    Player(Map map) {
        this.map = map;
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

    private boolean feed(Animal animal) {
        return false;
    }

    /**
     * the player picks up an item that is in the location.
     * @param item lowercase item
     */
    private void pickUpItem(Item item) {
        List<Item> roomItems = new ArrayList<>(currentLocation.getItems());
        for (Item a : roomItems) {
            if (a == item) {
                roomItems.remove(item);
                currentLocation.setItems(roomItems);
                List<Item> newInventory = this.inventory;
                newInventory.add(a);
                setInventory(newInventory);
            }
        }
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

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
