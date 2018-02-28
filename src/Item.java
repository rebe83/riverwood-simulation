import java.util.List;
import Data.*;
public class Item {

    private ItemType type;
    private String name;
    private int attack;
    private int uses;
    private int filling;
    private int thirst;
    private int happinessBoost;

    public Item(Weapon weapon) {
        this.type = ItemType.WEAPON;
        this.name = weapon.name();
        weaponSetup(weapon);
    }

    public Item(Litter litter) {
        this.type = ItemType.LITTER;
        this.name = litter.name();
        this.attack = 0;
        this.uses = -1;
    }

    public Item(Food food) {
        this.type = ItemType.FOOD;
        this.name = food.name();
        this.attack = 0;
        foodSetup(food);
    }

    private boolean weaponSetup(Weapon weapon) {
        if (weapon == Weapon.HUNTING_RIFLE) {
            this.uses = -1;
            this.attack = 20;
            return true;
        } else if (weapon == Weapon.KNIFE) {
            this.uses = 50;
            this.attack = 10;
            return true;
        } else if (weapon == Weapon.PISTOL) {
            this.uses = -1;
            this.attack = 15;
            return true;
        } else if (weapon == Weapon.STICK) {
            this.uses = 4;
            this.attack = 7;
            return true;
        }
        return false;
    }

    private boolean foodSetup(Food food) {
        if (food == Food.MEAT) {
            this.filling = 10;
            this.uses = 1;
            this.thirst = 4;
            this.happinessBoost = 7;

        } else if (food == Food.SALT_LICK) {
            this.filling = 0;
            this.uses = 20;
            this.thirst = 6;
            this.happinessBoost = 8;

        } else if (food == Food.SEEDS) {
            this.filling = 10;
            this.uses = 5;
            this.thirst = 1;
            this.happinessBoost = 5;

        } else if (food == Food.SUGAR_CUBES) {
            this.filling = 2;
            this.uses = 10;
            this.thirst = 1;
            this.happinessBoost = 10;
        }
        return false;
    }

    /**
     * returns the item with standard formatting to add/remove player inventory.
     * @param itemToFind item that may be in room
     * @return the item to add to inventory, or null if the item is not in the room.
     */
    public static Item getItem(String itemToFind, List<Item> items) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(itemToFind)) {
                return item;
            }
        }
        return null;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public int getFilling() {
        return filling;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHappinessBoost() {
        return happinessBoost;
    }
}
