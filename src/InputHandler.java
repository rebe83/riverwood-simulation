import java.util.Scanner;

public class InputHandler {

    private static Scanner SCAN = new Scanner(System.in);

    public static boolean inputHandler(String input, Player player) {
        String go = "go ";
        String take = "take ";
        String drop = "drop ";
        String list = "list";
        String quit = "quit";
        String exit = "exit";
        String duel = "duel ";
        String playerInfo = "playerinfo";


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
            return(InputHandler.exitHandler());

            //add in combat commands here
        } else if (input.toLowerCase().regionMatches(0,duel,0,5)) {
            if (MonsterAdventure.layout.getMonster(input.toLowerCase().substring(5)) != null
                    && player.currentRoom.monstersToString().contains(input.toLowerCase().substring(5))) {
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
        if(player.currentRoom.getDirRoom(substring.toLowerCase()) != null) {
            player.currentRoom = player.currentRoom.getDirRoom(substring.toLowerCase());
            return true;
        } else {
            System.out.println("I can't go " + substring);
            return false;
        }
    }
    private static boolean takeHandler(String substring, Player player) {
        if (Item.getItem(substring.toLowerCase(), player.currentRoom.items) != null) {
            player.pickUpItem(Item.getItem(substring.toLowerCase(), player.currentRoom.items));
            return true;
        } else {
            System.out.println("I can't take " + substring.toLowerCase());
            return false;
        }
    }
    private static boolean dropHandler(String substring, Player player) {
        if (Item.getItem(substring.toLowerCase(), player.inventory) != null) {
            player.dropItem(Item.getItem(substring.toLowerCase(), player.inventory));
            return true;
        } else {
            System.out.println("I don't have " + substring.toLowerCase());
            return false;
        }
    }
    private static boolean listHandler(Player player) {
        try {
            System.out.println(Item.itemsToString(player.inventory));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private static boolean playerInfoHandler(Player player) {
        try {
            System.out.println("Level: " + player.level + "Attack: " + player.attack + "Health: " + player.health);
            return true;
        } catch (NullPointerException n) {
            return false;
        }
    }
    private static boolean exitHandler() {
        MonsterAdventure.gameOn = false;
        return !MonsterAdventure.gameOn;
    }
}
