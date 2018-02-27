import java.util.Scanner;

public class Battler {

    private Player player;
    private Monster monster;
    private Room room;
    private boolean battling;

    protected Battler(Player player, String monster) {
        this.player = player;
        this.monster = MonsterAdventure.layout.getMonster(monster);
        this.room = player.currentRoom;
        battling = true;
    }

    public boolean battle() {
        Scanner scan = new Scanner(System.in);
        String input;
        Double damage;
        while(battling) {
            System.out.println("You engage the " + monster.name + " in a duel!");
            input = scan.nextLine();

            if(input.toLowerCase().regionMatches(0,"attack",0,6)) {
                damage = player.attack - monster.defense;
                if (input.toLowerCase().equals("attack with " )) {
                    if (Item.getItem(input.substring(12), player.inventory) != null) {
                        damage = player.attack + Item.getItem(input.substring(12), player.inventory).damage - monster.defense;
                    }
                }
                monster.health = monster.health - damage;
                if (monster.health < 0) {
                    System.out.println("Congratulations! You have slain the monster.");

                }
            }

        }
        return true;
    }
}
