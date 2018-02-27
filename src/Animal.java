import java.util.List;
import java.util.ArrayList;
import Data.AnimalType;

public class Animal {

    private enum AnimalType {FOX, SNAKE, BEAVER, RACCOON, DEER, POSSUM, MOUSE, SQUIRREL, CARDINAL, SPARROW, OWL, HAWK, COUGAR, COYOTE}

    private AnimalType type;
    private List<AnimalType> prey;
    private List<Item> food;
    private Location location;
    private Location previousLocation;
    private int health;
    private int attack;
    private int fear;
    private int hunger;
    private int thirst;
    private boolean living;
    private boolean pregnant;
    private int monthsPregnant;

    Animal() {
        this.type = this.typeAssign();
        this.prey = this.preyAssign(this.type);
        this.food = this.foodAssign(this.type);
        this.health = this.healthAssign(this.type);
        this.attack = this.attackAssign(this.type);
        this.fear = 0;
        this.hunger = 5;
        this.thirst = 5;
        this.living = true;
        this.pregnant = false;
        this.monthsPregnant = 0;
    }

    private int attack(Player player) {
        return 0;
    }

    private int attack(Animal animal) {
        return 0;
    }

    private boolean eat() {
        return false;
    }

    private boolean drink() {
        return false;
    }

    private boolean move() {
        return false;
    }

    private boolean follow(Player player) {
        return false;
    }

    private boolean follow(Animal animal) {
        return false;
    }

    private boolean birth(Animal animal) {
        if(this.pregnant) {
            if(this.monthsPregnant == 10) {
                location.addAnimal(this.type);
                this.pregnant = false;
            }
        }
    }
    private AnimalType typeAssign() {

    }
}
