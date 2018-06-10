package zoo.animal.service;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomic on 10.06.18.
 */
public class AnimalService {

    public static final Animal UNKNOWN_ANIMAL = new Animal(-1, "Unknown Animal", AnimalType.UNKNOWN);
    public static int CURRENT_INDEX = 1;
    private static List<Animal> ANIMALS = new ArrayList<>();

    static {
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Gold fish", AnimalType.FISH));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Nemo", AnimalType.FISH));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Szczupak", AnimalType.FISH));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Turtle Leonardo", AnimalType.REPTILE));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Turtle Donatello", AnimalType.REPTILE));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Crocodile Jerry", AnimalType.REPTILE));
    }

    public Animal findOne(int id) {
        return ANIMALS
                .stream()
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(UNKNOWN_ANIMAL);
    }

    public List<Animal> findAll() {
        return ANIMALS;
    }

    public void add(Animal animal) {
        ANIMALS.add(animal);
    }
}
