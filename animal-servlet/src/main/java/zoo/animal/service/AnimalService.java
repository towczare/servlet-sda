package zoo.animal.service;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomic on 10.06.18.
 */
public class AnimalService {

    private static List<Animal> ANIMALS = new ArrayList<>();

    static {
        ANIMALS.add(new Animal("Gold fish", AnimalType.FISH));
        ANIMALS.add(new Animal("Nemo", AnimalType.FISH));
        ANIMALS.add(new Animal("Szczupak", AnimalType.FISH));
        ANIMALS.add(new Animal("Turtle Leonardo", AnimalType.REPTILE));
        ANIMALS.add(new Animal("Turtle Donatello", AnimalType.REPTILE));
        ANIMALS.add(new Animal("Crocodile Jerry", AnimalType.REPTILE));
    }

    public Animal findOne(String id) {


        return null;
    }

    public List<Animal> findAll() {
        return ANIMALS;
    }

    public void add(Animal animal) {
        ANIMALS.add(animal);
    }
}
