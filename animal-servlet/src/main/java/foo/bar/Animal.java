package foo.bar;

public class Animal {
    private Long id;
    private String name;
    private AnimalType type;

    public Animal(Long id, String name, AnimalType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
