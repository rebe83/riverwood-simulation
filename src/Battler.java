import java.util.Scanner;
import Data.*;

public class Battler {

    private Player player;
    private Animal animal;
    private Location room;
    private boolean battling;

    public Battler(Player player, String animalName) {
        this.player = player;
        this.animal = room.getAnimal(animalName);
        this.room = player.getCurrentLocation();
        battling = true;
    }

    public boolean battle() {
        Scanner scan = new Scanner(System.in);
        String input;
        int damage;
        while(battling) {
            System.out.println("You engage the " + animal.getBreed().name() + " in a duel!");
            input = scan.nextLine();

            if(input.toLowerCase().regionMatches(0,"attack",0,6)) {
                damage = player.getAttack() - animal.getDefense();
                if (input.toLowerCase().equals("attack with " )) {
                    if (Item.getItem(input.substring(12), player.getInventory()) != null) {
                        damage = player.getAttack()
                                + Item.getItem(input.substring(12), player.getInventory()).getAttack()
                                - animal.getDefense();
                    }
                }
                animal.setHealth(animal.getHealth() - damage);
                if (animal.getHealth() < 0) {
                    System.out.println("You have slain the " + animal.getBreed().name() + ".");

                }
            }

        }
        return true;
    }
}
