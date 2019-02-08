package zoo.animal.repository;

import zoo.animal.model.Animal;

import java.util.Map;

public interface AnimalRepository {
    Animal findOne(Integer id);
    Map<Integer, Animal> findAll();
    void add(Animal animal);
    void remove(Integer idToRemove);
    void update(Integer animalId, Animal animal);
}
