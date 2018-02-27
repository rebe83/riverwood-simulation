
public class Simulation {
    private static Player player;
    private Map map;
    private int timePassed = 0;

    Simulation() {
        this.player = new Player();
        this.map = new Map();
    }

    public static void main(String[] args) {
        boolean gameOn = true;
        player.getCurrentLocation() = map.getRandomLocation();

        while(gameOn) {
            System.out.println(getCurrentLocation().description);
            
            if (getCurrentLocation().items != null) {
                System.out.println("This room contains " + Item.itemsToString(getCurrentLocation().items));
            } else {
                System.out.println("This room is empty.");
            }
            if (getCurrentLocation().monsterNames != null) {
                System.out.println("There is a(n) " + getCurrentLocation().monstersToString() + " here.");
            } else {
                System.out.println("There are no monsters in this room.");
            }
            if (getCurrentLocation().directions != null) {
                System.out.println("From here, you can go: " + getCurrentLocation().directionsToString());
            } else {
                System.out.println("There is nowhere you can go.");
            }
            String input = scan.nextLine();

            InputHandler.inputHandler(input, player);
        }
    }

}
