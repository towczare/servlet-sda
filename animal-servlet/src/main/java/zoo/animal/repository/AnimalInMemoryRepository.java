package zoo.animal.repository;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalInMemoryRepository implements AnimalRepository{

    public static final Animal UNKNOWN_ANIMAL = new Animal(-1, "Unknown Animal", 0, "http://google.com", "-", AnimalType.UNKNOWN);
    public static final int MAX_INDEX = 999999999;
    private static Map<Integer, Animal> ANIMALS = new HashMap<>();

    static {
        //int id, String name, int age, String imageUrl, String description, AnimalType type
        addAnimal(autoincrement(), "Gold fish", 5, "https://upload.wikimedia.org/wikipedia/commons/3/39/%D7%93%D7%92%D7%99%D7%9D_%28cropped%29.jpg",
                "Złota rybka – ogólna nazwa licznych odmian hodowlanych populacji jednego z podgatunków karasia chińskiego – Carassius auratus auratus – popularnie zwanego karasiem ozdobnym lub welonem, choć ta ostatnia nazwa odnosi się tylko do niektórych odmian o długich płetwach. Złote rybki to popularne na całym świecie ryby ozdobne, głównie akwariowe. Były hodowane w basenach (sadzawki, oczka wodne) i akwariach w Chinach już od VII wieku n.e.[1] Znanych jest wiele odmian różniących się kształtem ciała, długością i kształtem płetw, jak i ubarwieniem. Poszczególne odmiany powinny odpowiadać określonym normom, a prowadzący do tego proces jest długotrwały, dlatego „rasowe” osobniki są trudno dostępne i bardzo drogie. Ryby te nie są polecane dla początkujących akwarystów. Zwłaszcza trzymanie ich w kulach wywołuje często burzliwe dyskusje – jako sporych rozmiarów ryby stadne powinny być trzymane w zbiornikach o odpowiednio dobranej wielkości i właściwej filtracji wody.", AnimalType.FISH);
        addAnimal(autoincrement(), "Turtle Leonardo", 36, "https://i1.wp.com/www.teenagemutantninjaturtles.com/wp-content/uploads/2012/04/Leonardo-2003-cartoon.jpg", "Leonardo, nickname Leo, is a fictional character and one of the four main characters in Teenage Mutant Ninja Turtles comics and all related media.[1][2]", AnimalType.REPTILE);
        addAnimal(autoincrement(), "Nemo", 14, "https://vignette.wikia.nocookie.net/pixar/images/3/39/59.png", "Nemo fish",  AnimalType.FISH);
    }

    public Animal findOne(Integer id) {
        return ANIMALS.getOrDefault(id, UNKNOWN_ANIMAL);
    }

    public Map<Integer, Animal> findAll() {
        return ANIMALS;
    }

    public void add(Animal animal) {
        addAnimal(autoincrement(), animal.getName(), animal.getAge(), animal.getImageUrl(), animal.getDescription(), animal.getType());
    }

    public void remove(Integer idToRemove) {
        ANIMALS.remove(idToRemove);
    }

    public void update(Integer animalId, Animal animal) {
        ANIMALS.put(animalId, animal);
    }

    private static void addAnimal(Integer id, String name, int age, String picture, String description, AnimalType type) {
        ANIMALS.put(id, new Animal(id, name, age, picture, description, type));
    }

    private static Integer autoincrement() {
        Integer newIndexMaybe = ANIMALS.size() + 1;
        if(ANIMALS.containsKey(newIndexMaybe)) {
            newIndexMaybe = ThreadLocalRandom.current().nextInt(1, MAX_INDEX);
        }
        return newIndexMaybe;
    }
}
