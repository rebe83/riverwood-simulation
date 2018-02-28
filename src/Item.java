import java.util.List;
import Data.*;
public class Item {

    private enum ItemType {LITTER, FOOD, WEAPON}

    private ItemType type;
    private String name;
    private int attack;
    private int uses;

    public Item(Weapon weapon) {
        this.type = ItemType.WEAPON;
        this.name = this.type.name();
        weaponSetup(weapon);
    }

    public Item(Litter litter) {
        this.type = ItemType.LITTER;
        this.name = this.type.name();
        this.attack = 0;
        this.uses = -1;
    }

    public Item(Food food) {
        this.type = ItemType.FOOD;
        this.name = this.type.name();
        this.attack = 0;
        this.uses = 1;

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

    /**
     * returns the item with standard formatting to add to player inventory
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
}
