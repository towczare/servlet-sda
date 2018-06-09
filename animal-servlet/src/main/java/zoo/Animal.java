package zoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by tomic on 09.06.18.
 */
public enum Animal {
    DOG,
    CAT,
    FISH;

    private static final Random RANDOM = new Random();
    private static List<Animal> ANIMALS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = ANIMALS.size();

    public static Animal random() {
        return ANIMALS.get(RANDOM.nextInt(SIZE));
    }
}
