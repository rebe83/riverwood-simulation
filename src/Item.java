public class Item {

    private enum ItemType {LITTER, FOOD, WEAPON}

    private ItemType type;
    private String name;
    private int attack;
    private int uses;

    /**
     * returns the item with standard formatting to add to player inventory
     * @param itemToFind item that may be in room
     * @return the item to add to inventory, or null if the item is not in the room.
     */
    public static Item getItem(String itemToFind, Item[] items) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(itemToFind)) {
                return item;
            }
        }
        return null;
    }
}
