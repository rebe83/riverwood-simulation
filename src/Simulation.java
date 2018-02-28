import java.util.Scanner;
import java.lang.StringBuilder;

public class Simulation {
    private static Player player;
    private static Map map;
    private static int timePassed;
    private static final Scanner scan = new Scanner(System.in);
    private static boolean gameOn;
    private static StringBuilder stringB = new StringBuilder();

    private static void setup() {
        map = new Map();
        player = new Player();
        timePassed = 0;
        gameOn = true;
        player.setCurrentLocation(map.getLocations()[0][0]);
    }

    public static void main(String[] args) {
        setup();

        while(gameOn) {

            System.out.println(timePassed + " hours have passed since you began.");
            System.out.println("You are standing by a " + player.getCurrentLocation().getLocationType().toString().toLowerCase());

            if (player.getCurrentLocation().getItems() != null) {
                for (Item a : player.getCurrentLocation().getItems()) {
                    stringB.append(a.getName().toLowerCase()).append(", ");
                }
                System.out.println("There is/are a(n) " + stringB.toString() + "laying around.");
                stringB = new StringBuilder();
            } else {
                System.out.println("This room is empty.");
            }
            if (player.getCurrentLocation().getAnimals() != null) {
                for (Animal a : player.getCurrentLocation().getAnimals()) {
                    stringB.append(a.getBreed().toString().toLowerCase()).append(", ");
                }
                System.out.println("There is a(n) " + stringB + "here.");
                stringB = new StringBuilder();
            } else {
                System.out.println("There are no animals here.");
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

    public static boolean isGameOn() {
        return gameOn;
    }

    public static void setGameOn(boolean gameOn) {
        Simulation.gameOn = gameOn;
    }

    public static int getTimePassed() {
        return timePassed;
    }
}
