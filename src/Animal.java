import java.util.*;

import Data.*;

public class Animal {

    private AnimalBreed breed;
    private List<AnimalBreed> prey = new ArrayList<>();
    private List<Food> food = new ArrayList<>();
    private List<Resource> resources = new ArrayList<>();
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
        this.location = location;
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
        this.location = location;
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

    private boolean breedManager() {
        if (this.breed == null) {
            AnimalBreed[] animalBreeds = AnimalBreed.values();
            int randomIndex = map.randomIndex(animalBreeds.length);
            this.breed = animalBreeds[randomIndex];
        }

        if (this.breed == AnimalBreed.FOX) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.POSSUM, AnimalBreed.SQUIRREL);
            this.food = Arrays.asList(Food.MEAT, Food.SUGAR_CUBES);
            this.resources = Arrays.asList(Resource.TRASH, Resource.DEAD_ANIMAL);
            this.attack = 2;
            this.health = 40;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.BEAVER) {
            this.prey = null;
            this.food = Arrays.asList(Food.SEEDS, Food.SUGAR_CUBES);
            this.resources = Arrays.asList(Resource.TREE, Resource.GRASS);
            this.attack = 3;
            this.health = 20;
            this.defense = 0;
            if (location.getMap().getSeason() == Season.WINTER) {
                this.hibernating = true;
            } else {
                this.hibernating = false;
            }

        } else if (this.breed == AnimalBreed.CARDINAL) {
            this.prey = null;
            this.food.add(Food.SEEDS);
            resources.add(Resource.TREE);
            this.attack = 1;
            this.health = 5;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.COUGAR) {
            this.prey = Arrays.asList(AnimalBreed.values());
            this.food = Arrays.asList(Food.MEAT, Food.SALT_LICK);
            this.resources.add(Resource.DEAD_ANIMAL);
            this.attack = 10;
            this.health = 500;
            this.defense = 3;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.COYOTE) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.POSSUM, AnimalBreed.SPARROW, AnimalBreed.SQUIRREL, AnimalBreed.FOX, AnimalBreed.RACCOON);
            this.food.add(Food.MEAT);
            this.resources = Arrays.asList(Resource.TRASH, Resource.DEAD_ANIMAL);
            this.attack = 7;
            this.health = 50;
            this.defense = 1;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.DEER) {
            this.prey = null;
            this.food = Arrays.asList(Food.SUGAR_CUBES, Food.SALT_LICK);
            this.resources.add(Resource.GRASS);
            this.attack = 4;
            this.health = 60;
            this.defense = 1;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.HAWK) {
            this.prey = Arrays.asList(AnimalBreed.OWL, AnimalBreed.CARDINAL, AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.POSSUM, AnimalBreed.SPARROW, AnimalBreed.SQUIRREL, AnimalBreed.MOUSE);
            this.food = Arrays.asList(Food.MEAT, Food.SUGAR_CUBES);
            this.resources = Arrays.asList(Resource.TRASH, Resource.DEAD_ANIMAL);
            this.attack = 3;
            this.health = 10;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.SNAKE) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.SQUIRREL);
            this.food.add(Food.MEAT);
            this.resources = Arrays.asList(Resource.DEAD_ANIMAL, Resource.PAVEMENT);
            this.attack = 1;
            this.health = 6;
            this.defense = 2;
            if (location.getMap().getSeason() == Season.WINTER) {
                this.hibernating = true;
            } else {
                this.hibernating = false;
            }

        } else if (this.breed == AnimalBreed.RACCOON) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.SQUIRREL);
            this.food = Arrays.asList(Food.MEAT, Food.SUGAR_CUBES, Food.SEEDS);
            this.resources = Arrays.asList(Resource.TRASH, Resource.DEAD_ANIMAL);
            this.attack = 3;
            this.health = 20;
            this.defense = 1;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.MOUSE) {
            this.prey = null;
            this.food = Arrays.asList(Food.SUGAR_CUBES, Food.SEEDS);
            this.resources = Arrays.asList(Resource.GRASS, Resource.TRASH);
            this.attack = 1;
            this.health = 2;
            this.defense = 0;
            if (location.getMap().getSeason() == Season.WINTER) {
                this.hibernating = true;
            } else {
                this.hibernating = false;
            }

        } else if (this.breed == AnimalBreed.OWL) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.SPARROW, AnimalBreed.SQUIRREL);
            this.food = Arrays.asList(Food.MEAT, Food.SEEDS);
            this.resources = Arrays.asList(Resource.TREE, Resource.DEAD_ANIMAL);
            this.attack = 3;
            this.health = 10;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.POSSUM) {
            this.prey = Arrays.asList(AnimalBreed.SNAKE, AnimalBreed.MOUSE, AnimalBreed.SQUIRREL);
            this.food = Arrays.asList(Food.MEAT, Food.SUGAR_CUBES);
            this.resources = Arrays.asList(Resource.TRASH, Resource.DEAD_ANIMAL);
            this.attack = 3;
            this.health = 15;
            this.defense = 0;
            this.hibernating = false;

        } else if (this.breed == AnimalBreed.SPARROW) {
            this.prey = null;
            this.food.add(Food.SEEDS);
            this.resources.add(Resource.TREE);
            this.attack = 0;
            this.health = 3;
            this.defense = 0;
            if (location.getMap().getSeason() == Season.WINTER) {
                this.hibernating = true;
            } else {
                this.hibernating = false;
            }

        } else if (this.breed == AnimalBreed.SQUIRREL) {
            this.prey = null;
            this.food = Arrays.asList(Food.SEEDS, Food.SUGAR_CUBES);
            this.resources = Arrays.asList(Resource.TRASH, Resource.TREE);
            this.attack = 1;
            this.health = 6;
            this.defense = 0;
            this.hibernating = false;
        }
        return false;

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
            for (Resource b : location.getResources()) {
                if (b.name().equals("GRASS") && resources.contains(b)) {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 5;
                    this.stress = this.stress - 5;
                    return true;

                } else if (b.name().equals("DEAD_ANIMAL") && resources.contains(b))   {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 6;
                    this.stress = this.stress - 5;
                    return true;

                } else if (b.name().equals("GARBAGE") && resources.contains(b)) {
                    this.hunger = this.hunger - 10;
                    this.thirst = this.thirst + 6;
                    this.stress = this.stress - 3;
                    return true;

                } else if (b.name().equals("TREE") && resources.contains(b)) {
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

    public AnimalBreed getBreed() {
        return breed;
    }

    public List<AnimalBreed> getPrey() {
        return prey;
    }

    public List<Food> getFood() {
        return food;
    }

    public Location getLocation() {
        return location;
    }

    public Location getPreviousLocation() {
        return previousLocation;
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

    public int getDefense() {
        return defense;
    }

    public int getStress() {
        return stress;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public boolean isLiving() {
        return living;
    }

    public boolean isHibernating() {
        return hibernating;
    }

    public boolean isFemale() {
        return female;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public int getMonthsPregnant() {
        return monthsPregnant;
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
