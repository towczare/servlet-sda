package foo.bar;

public enum AnimalType {

    INSECT,
    BIRD,
    FISH,
    MAMMAL;

    public static AnimalType of(String type) {
        try {
            if(type == null) {
                return MAMMAL;
            }
            return valueOf(type.toUpperCase());
        } catch(IllegalArgumentException ex) {
            return MAMMAL;
        }
    }
}
