package foo.bar;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalService {

    private static final Random RANDOM = new Random();
    private static Map<Long, Animal> ANIMALS = new HashMap<>();
    private static Long CURRENT_INDEX = 1l;


    public AnimalService() {
        populateAnimalList();
    }

    public Animal getRandomAnimal(AnimalType type) {

        List<Animal> animalsOfType = ANIMALS.values().stream()
                .filter(a -> a.getType() == type)
                .collect(Collectors.toList());

        return animalsOfType.get(RANDOM.nextInt(animalsOfType.size()));
    }

    private void populateAnimalList() {
        addAnimal(CURRENT_INDEX, "Piesek Pimpuś", AnimalType.MAMMAL);
        addAnimal(CURRENT_INDEX, "Kot Filemon", AnimalType.MAMMAL);
        addAnimal(CURRENT_INDEX, "Mysz Miki", AnimalType.MAMMAL);
        addAnimal(CURRENT_INDEX, "Pszczółka Maja", AnimalType.INSECT);
        addAnimal(CURRENT_INDEX, "Mrówka Z", AnimalType.INSECT);
        addAnimal(CURRENT_INDEX, "Szczupak król wód", AnimalType.FISH);
        addAnimal(CURRENT_INDEX, "Rybka Nemo", AnimalType.FISH);
        addAnimal(CURRENT_INDEX, "Dzięcioł Felix", AnimalType.BIRD);
        addAnimal(CURRENT_INDEX, "Gołąb", AnimalType.BIRD);
    }

    private void addAnimal(Long currentIndex, String name, AnimalType type) {
        ANIMALS.put(currentIndex, new Animal(currentIndex, name, type));
        CURRENT_INDEX++;
    }

    public void add(String name, AnimalType type) {
        addAnimal(CURRENT_INDEX, name, type);
    }

    public List<Animal> findAll() {
        return ANIMALS.values().stream().collect(Collectors.toList());
    }

    public Animal getAnimal(String animalId) {
        return ANIMALS.get(Long.valueOf(animalId));
    }

    public void update(Animal updatedAnimal) {
        Long id = updatedAnimal.getId();
        ANIMALS.put(id, updatedAnimal);
    }
}
