package zoo.animal.service;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomic on 10.06.18.
 */
public class AnimalService {

    public static final Animal UNKNOWN_ANIMAL = new Animal(-1, "Unknown Animal", 0, "http://google.com", "-", AnimalType.UNKNOWN);
    public static int CURRENT_INDEX = 1;
    private static List<Animal> ANIMALS = new ArrayList<>();

    static {
        //int id, String name, int age, String imageUrl, String description, AnimalType type

        ANIMALS.add(new Animal(CURRENT_INDEX++, "Gold fish", 5, "https://upload.wikimedia.org/wikipedia/commons/3/39/%D7%93%D7%92%D7%99%D7%9D_%28cropped%29.jpg",
               "Złota rybka – ogólna nazwa licznych odmian hodowlanych populacji jednego z podgatunków karasia chińskiego – Carassius auratus auratus – popularnie zwanego karasiem ozdobnym lub welonem, choć ta ostatnia nazwa odnosi się tylko do niektórych odmian o długich płetwach. Złote rybki to popularne na całym świecie ryby ozdobne, głównie akwariowe. Były hodowane w basenach (sadzawki, oczka wodne) i akwariach w Chinach już od VII wieku n.e.[1] Znanych jest wiele odmian różniących się kształtem ciała, długością i kształtem płetw, jak i ubarwieniem. Poszczególne odmiany powinny odpowiadać określonym normom, a prowadzący do tego proces jest długotrwały, dlatego „rasowe” osobniki są trudno dostępne i bardzo drogie. Ryby te nie są polecane dla początkujących akwarystów. Zwłaszcza trzymanie ich w kulach wywołuje często burzliwe dyskusje – jako sporych rozmiarów ryby stadne powinny być trzymane w zbiornikach o odpowiednio dobranej wielkości i właściwej filtracji wody.", AnimalType.FISH));
        ANIMALS.add(new Animal(CURRENT_INDEX++, "Turtle Leonardo", 3, "https://i1.wp.com/www.teenagemutantninjaturtles.com/wp-content/uploads/2012/04/Leonardo-2003-cartoon.jpg", "Leonardo, nickname Leo, is a fictional character and one of the four main characters in Teenage Mutant Ninja Turtles comics and all related media.[1][2]", AnimalType.REPTILE));
//        ANIMALS.add(new Animal(CURRENT_INDEX++, "Nemo", 4,  AnimalType.FISH));
//        ANIMALS.add(new Animal(CURRENT_INDEX++, "Szczupak", 1, AnimalType.FISH));
//        ANIMALS.add(new Animal(CURRENT_INDEX++, "Turtle Donatello", 102, AnimalType.REPTILE));
//        ANIMALS.add(new Animal(CURRENT_INDEX++, "Crocodile Jerry", 35, AnimalType.REPTILE));
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
