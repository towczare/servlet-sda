package foo.bar;

public enum AnimalType {

    INSECT("Insect"),
    BIRD("Bird"),
    FISH("Fish"),
    MAMMAL("Mammal");

    private String label;

    AnimalType(String label) {
        this.label = label;
    }

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

    public String getLabel() {
        return label;
    }
}
