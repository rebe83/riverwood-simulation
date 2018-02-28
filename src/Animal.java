import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
    private int defense;
    private int stress;
    private int hunger;
    private int thirst;
    private boolean living;
    private boolean hibernating;
    private boolean female;
    private boolean pregnant;
    private int monthsPregnant;
    private int hashCode;

    /**
     * Used in the initialization of the map
     * @param location the room where the animal is created
     */
    Animal(Location location) {
        this.map = location.getMap();
        breedManager();
        this.female = (map.randomIndex(2) % 2 == 0);
        this.stress = 0;
        this.hunger = 5;
        this.thirst = 5;
        this.living = true;
        //gives a 5.9% chance of pregnancy when created
        this.pregnant = (map.randomIndex(1000) % 17 == 0);
        if(pregnant && !hibernating) {
            this.monthsPregnant = (map.randomIndex(9));
        } else {
            this.monthsPregnant = 0;
        }
        hashCode = hashCode();
    }

    /**
     * Used to create an animal when an animal gives birth.
     * @param breed the breed of the mother
     * @param location where the animal was born
     */
    private Animal(AnimalBreed breed, Location location) {
        this.map = location.getMap();
        this.breed = breed;
        breedManager();
        this.female = (map.randomIndex(2) % 2 == 0);
        this.stress = 0;
        this.hunger = 5;
        this.thirst = 5;
        this.living = true;
        this.pregnant = false;
        this.monthsPregnant = 0;
        hashCode = hashCode();
    }

    private boolean attack(Player player) {
        int playerHealth = player.getHealth();
        player.takeDamage(attack);
        return (player.getHealth() < playerHealth);
    }

    private boolean attack(Animal animal) {
        int playerHealth = animal.getHealth();
        animal.takeDamage(attack);
        return (animal.getHealth() < playerHealth);
    }

    public boolean takeDamage(int attack) {
        int previousHealth = health;
        int damage = attack - defense;
        health = health - damage;
        return (health < previousHealth);
    }

    public boolean eat(Item food) {
        if (this.stress < 10 || this.hunger <= 0) {
            this.hunger = this.hunger - food.getFilling();
            this.thirst = this.thirst + food.getThirst();
            this.stress = this.stress - food.getHappinessBoost();
            food.setUses(food.getUses() - 1);
            return true;
        } else  {
            return false;
        }
    }

    private boolean eat() {
        if (this.hunger >= 20) {
            for (Food b : food) {
                if (b.name().equals("GRASS")) {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 5;
                    this.stress = this.stress - 5;
                    return true;

                } else if (b.name().equals("DEAD_ANIMAL"))   {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 6;
                    this.stress = this.stress - 5;
                    return true;

                } else if (b.name().equals("GARBAGE")) {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 6;
                    this.stress = this.stress - 3;
                    return true;

                } else if (b.name().equals("TREE")) {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 4;
                    this.stress = this.stress - 6;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean drink() {
        return false;
    }

    public boolean useResource(Resource resource) {
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
                        if (animal1.stress <= 10
                                && animal1.map.getNumBreeds()[animal1.breed.ordinal()] < 10
                                && animal1.map.getTotalAnimals() < 50) {
                            animal1.pregnant = true;
                            return true;
                        }
                    } else {
                        if (animal2.stress <= 10
                                && animal2.map.getNumBreeds()[animal2.breed.ordinal()] < 10
                                && animal2.map.getTotalAnimals() < 50) {
                            animal2.pregnant = true;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean birth() {
        if(this.pregnant) {
            if(this.monthsPregnant == 10) {
                location.addAnimal(new Animal(breed, location));
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
            this.attack = 3;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.BEAVER) {
            this.prey = null;

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

    public AnimalBreed getBreed() {
        return breed;
    }

    public void setBreed(AnimalBreed breed) {
        this.breed = breed;
    }

    public List<AnimalBreed> getPrey() {
        return prey;
    }

    public void setPrey(List<AnimalBreed> prey) {
        this.prey = prey;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isHibernating() {
        return hibernating;
    }

    public void setHibernating(boolean hibernating) {
        this.hibernating = hibernating;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getMonthsPregnant() {
        return monthsPregnant;
    }

    public void setMonthsPregnant(int monthsPregnant) {
        this.monthsPregnant = monthsPregnant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return hashCode == animal.hashCode;
    }

    public int hashCode() {
        return Objects.hash(hashCode);
    }
}
