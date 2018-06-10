package zoo.animal.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by tomic on 09.06.18.
 */
public enum AnimalType {

    FISH("fish"), MAMMALS("mammals"), REPTILE("reptile"), INSECT("insect"),
    BIRD("bird"), AMPHIBIAN("amphibian"), UNKNOWN("unknown");

    private static final Random RANDOM = new Random();
    private static List<AnimalType> ANIMALS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = ANIMALS.size();
    private String name;
    private AnimalType(String name) {
        this.name = name;
    }

    public static AnimalType random() {
        return ANIMALS.get(RANDOM.nextInt(SIZE));
    }

    public static AnimalType getAnimalType(String type) {
        try {
            return AnimalType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Unknown type. Returning type UNKNOWN");
            return AnimalType.UNKNOWN;
        }
    }

    public static List<AnimalType> getAvailableTypesForUser() {
        return Arrays.asList(AnimalType.values())
                .stream()
                .filter(at -> at != AnimalType.UNKNOWN)
                .collect(Collectors.toList());
    }

    public String getName() {
        return this.name;
    }
}
