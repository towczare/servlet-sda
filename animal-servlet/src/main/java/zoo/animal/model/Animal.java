package zoo.animal.model;

/**
 * Created by tomic on 09.06.18.
 */
public class Animal {

    private int id;
    private String name;
    private AnimalType type;

    public Animal(int id, String name, AnimalType type) {
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

    public int getId() {
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
