package foo.bar;

public class Animal {

    private String name;
    private AnimalType type;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
