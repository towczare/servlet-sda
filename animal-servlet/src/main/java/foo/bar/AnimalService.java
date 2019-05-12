package foo.bar;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalService {

    private static final Random RANDOM = new Random();
    private static Map<AnimalType, List<Animal>> ANIMALS = new HashMap<>();

    public AnimalService() {
        populateAnimalList();
    }

    public Animal getRandomAnimal(AnimalType type) {
        List<Animal> animalsOfType = ANIMALS.get(type);
        return animalsOfType.get(RANDOM.nextInt(animalsOfType.size()));
    }

    private void populateAnimalList() {
        List<Animal> mammals = new ArrayList<>();
        mammals.add(new Animal("Piesek Pimpuś"));
        mammals.add(new Animal("Kot Filemon"));
        mammals.add(new Animal("Mysz Miki"));
        ANIMALS.put(AnimalType.MAMMAL, mammals);

        List<Animal> ants = new ArrayList<>();
        ants.add(new Animal("Pszczółka Maja"));
        ants.add(new Animal("Mrówka Z"));
        ANIMALS.put(AnimalType.INSECT, ants);

        List<Animal> fishes = new ArrayList<>();
        fishes.add(new Animal("Szczupak król wód"));
        fishes.add(new Animal("Rybka Nemo"));
        ANIMALS.put(AnimalType.FISH, fishes);


        List<Animal> birds = new ArrayList<>();
        birds.add(new Animal("Dzięcioł Felix"));
        birds.add(new Animal("Gołąb"));
        ANIMALS.put(AnimalType.BIRD, birds);

    }

    public void add(String animalType, Animal animal) {
        AnimalType type = AnimalType.of(animalType);
        List<Animal> animals = ANIMALS.get(type);
        animals.add(animal);
        ANIMALS.put(type, animals);
    }

    public List<Animal> findAll() {
        return ANIMALS.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
