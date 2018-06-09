package zoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by tomic on 09.06.18.
 */
public enum AnimalType {

    FISH, MAMMALS, REPTILE, INSECT, BIRD, AMPHIBIAN, UNKNOWN;

    private static final Random RANDOM = new Random();
    private static List<AnimalType> ANIMALS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = ANIMALS.size();

    public static AnimalType random() {
        return ANIMALS.get(RANDOM.nextInt(SIZE));
    }
}
