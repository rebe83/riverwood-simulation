import Data.*;
import java.util.List;
import java.util.ArrayList;

public class InputHandler {

    public static boolean inputHandler(String input, Player player) {
        String go = "go ";
        String take = "take ";
        String drop = "drop ";
        String list = "list";
        String quit = "quit";
        String exit = "exit";
        String duel = "attack ";
        String playerInfo = "playerinfo";
        String coordinates = "coordinates";
        String commands = "commands";


        if (input.toLowerCase().regionMatches(0, go,0 , 3)) {
            return(InputHandler.goHandler(input.substring(3), player));

        } else if (input.toLowerCase().regionMatches(0, take,0 , 5)) {
            return(InputHandler.takeHandler(input.substring(5), player));

        } else if (input.toLowerCase().regionMatches(0, drop,0,5)) {
            return(InputHandler.dropHandler(input.substring(5), player));

        } else if (input.toLowerCase().regionMatches(0, list,0,4)) {
            return listHandler(player);

        } else if (input.toLowerCase().regionMatches(0, quit,0,4)
                || input.toLowerCase().regionMatches(0, exit,0,4)) {
            return(InputHandler.exitHandler(player));

            //combat commands
        } else if (input.toLowerCase().regionMatches(0,duel,0,5)) {
            if (player.getCurrentLocation().getAnimal(input.toLowerCase().substring(5)) != null
                    && player.getCurrentLocation().getAnimals().toString().contains(input.toLowerCase().substring(5))) {
                Battler battle = new Battler(player, input.toLowerCase().substring(5));
                return battle.battle();
            } else {
                System.out.println("I can't duel " + input.substring(5) + ".");
                return false;
            }

            //add in playerinfo here
        } else if (input.toLowerCase().regionMatches(0,playerInfo,0,10)) {
            return playerInfoHandler(player);

        } else {
            System.out.println("I don't understand" + "'" + input + "'");
            return false;
        }
    }

    private static boolean goHandler(String substring, Player player) {
        Location currentLocation = player.getCurrentLocation();
        Map map = currentLocation.getMap();
        List<Direction> directions = new ArrayList<>(currentLocation.getDirections());

        if (directions.toString().toLowerCase().contains(substring.toLowerCase())) {
            for (Direction a : directions) {
                if (a.name().equalsIgnoreCase(substring)) {
                    if (a.name().equalsIgnoreCase("east")) {
                        player.setCurrentLocation(map.getLocations()
                                [currentLocation.getCoordinate() / 10][currentLocation.getCoordinate() % 10 + 1]);
                        return true;

                    } else if (a.name().equalsIgnoreCase("west")) {
                        player.setCurrentLocation(map.getLocations()
                                [currentLocation.getCoordinate() / 10][currentLocation.getCoordinate() % 10 - 1]);
                        return true;

                    } else if (a.name().equalsIgnoreCase("north")) {
                        player.setCurrentLocation(map.getLocations()
                                [currentLocation.getCoordinate() / 10 - 1][currentLocation.getCoordinate() % 10]);
                        return true;

                    } else if (a.name().equalsIgnoreCase("south")) {
                        player.setCurrentLocation(map.getLocations()
                                [currentLocation.getCoordinate() / 10 + 1][currentLocation.getCoordinate() % 10]);
                        return true;
                    }

                }
            }
        }
            System.out.println("I can't go " + substring);
            return false;
    }

    private static boolean takeHandler(String substring, Player player) {
        if (Item.getItem(substring.toLowerCase(), player.getCurrentLocation().getItems()) != null) {
            player.pickUpItem(Item.getItem(substring.toLowerCase(), player.getCurrentLocation().getItems()));
            return true;
        } else {
            System.out.println("I can't take " + substring.toLowerCase());
            return false;
        }
    }

    private static boolean dropHandler(String substring, Player player) {
        if (Item.getItem(substring.toLowerCase(), player.getInventory()) != null) {
            player.dropItem(Item.getItem(substring.toLowerCase(), player.getInventory()));
            return true;
        } else {
            System.out.println("I don't have " + substring.toLowerCase());
            return false;
        }
    }

    private static boolean listHandler(Player player) {
        try {
            System.out.println(player.getInventory().toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean playerInfoHandler(Player player) {
            System.out.println("Attack: " + player.getAttack() + "Health: " + player.getHealth());
            System.out.println(player.getInventory().toString());
            return true;
    }

    private static boolean exitHandler(Player player) {
        player.getSimulation().setGameOn(false);
        return !player.getSimulation().isGameOn();
    }
}
