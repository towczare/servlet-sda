package zoo.animal.model;

/**
 * Created by tomic on 09.06.18.
 */
public class Animal {

    private int id;
    private String name;
    private int age;
    private String imageUrl;
    private String description;
    private AnimalType type;

    public Animal(String name, int age, String imageUrl, String description, AnimalType type) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
        this.description = description;
        this.type = type;
    }

    public Animal(int id, String name, int age, String imageUrl, String description, AnimalType type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
        this.description = description;
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

    public int getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
