import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import Data.*;

public class Animal {

    private AnimalBreed breed;
    private List<AnimalBreed> prey = new ArrayList<>();
    private List<Food> food = new ArrayList<>();
    private Location location;
    private Location previousLocation;
    private Map map;
    private int health;
    private int attack;
    private int stress;
    private int hunger;
    private int thirst;
    private boolean living;
    private boolean hibernating;
    private boolean female;
    private boolean pregnant;
    private int monthsPregnant;

    Animal() {
        breedManager();
        this.female = (map.randomIndex(2) % 2 == 0);
        this.stress = 0;
        this.hunger = 5;
        this.thirst = 5;
        this.living = true;
        this.pregnant = false;
        this.monthsPregnant = 0;
    }
    Animal(AnimalBreed breed) {
        this.breed = breed;
        breedManager();
        this.female = (map.randomIndex(2) % 2 == 0);
        this.stress = 0;
        this.hunger = 5;
        this.thirst = 5;
        this.living = true;
        this.pregnant = false;
        this.monthsPregnant = 0;
    }

    private boolean attack(Player player) {
        int playerHealth = player.getHealth();
        player.takeDamage(this.attack);
        return (player.getHealth < playerHealth);
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

    private boolean mate(Animal animal1, Animal animal2) {
        if (animal1.female || animal2.female) {
            if (!animal1.female || !animal2.female) {
                if(animal1.breed == animal2.breed) {
                    if(animal1.female) {
                        animal1.pregnant = true;
                        return true;
                    } else {
                        animal2.pregnant = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean birth() {
        if(this.pregnant) {
            if(this.monthsPregnant == 10) {
                location.addAnimal(this.breed);
                this.pregnant = false;
                return true;
            }
        }
        return false;
    }

    private boolean breedManager() {
        if (this.breed == null) {
            AnimalBreed[] animalBreeds = AnimalBreed.values();
            int randomIndex = map.randomIndex(animalBreeds.length);
            this.breed = animalBreeds[randomIndex];
        }

        if (this.breed == AnimalBreed.FOX) {
            this.prey = Arrays.asList(AnimalBreed.HAWK, AnimalBreed.CARDINAL, AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.POSSUM, AnimalBreed.SPARROW, AnimalBreed.SQUIRREL);


        } else if (this.breed == AnimalBreed.BEAVER) {
            this.prey = 

        } else if (this.breed == AnimalBreed.CARDINAL) {

        } else if (this.breed == AnimalBreed.COUGAR) {

        } else if (this.breed == AnimalBreed.COYOTE) {

        } else if (this.breed == AnimalBreed.DEER) {

        } else if (this.breed == AnimalBreed.HAWK) {

        } else if (this.breed == AnimalBreed.SNAKE) {

        } else if (this.breed == AnimalBreed.RACCOON) {

        } else if (this.breed == AnimalBreed.MOUSE) {

        } else if (this.breed == AnimalBreed.OWL) {

        } else if (this.breed == AnimalBreed.POSSUM) {

        } else if (this.breed == AnimalBreed.SPARROW) {

        } else if (this.breed == AnimalBreed.SQUIRREL) {

        }
        return false;

    }
}
