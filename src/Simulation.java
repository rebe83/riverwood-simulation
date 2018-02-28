import java.util.Scanner;

public class Simulation {
    private static Player player;
    private static Map map;
    private static int timePassed;
    private static final Scanner scan = new Scanner(System.in);

    Simulation() {
        this.map = new Map();
        this.player = new Player(map);
        this.timePassed = 0;
    }

    public static void main(String[] args) {
        boolean gameOn = true;
        player.setCurrentLocation(map.getLocations()[2][2]);

        while(gameOn) {
            
            if (player.getCurrentLocation().getItems() != null) {
                System.out.println("This room contains " + player.getCurrentLocation().getItems().toString());
            } else {
                System.out.println("This room is empty.");
            }
            if (player.getCurrentLocation().getAnimals() != null) {
                System.out.println("There is a(n) " + player.getCurrentLocation().getAnimals().toString() + " here.");
            } else {
                System.out.println("There are no monsters in this room.");
            }
            if (player.getCurrentLocation().getDirections() != null) {
                System.out.println("From here, you can go: " + player.getCurrentLocation().getDirections().toString());
            } else {
                System.out.println("There is nowhere you can go.");
            }
            String input = scan.nextLine();

            InputHandler.inputHandler(input, player);
            timePassed ++;
        }
    }

}
