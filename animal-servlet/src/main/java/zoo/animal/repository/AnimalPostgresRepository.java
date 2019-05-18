package zoo.animal.repository;

import zoo.animal.model.Animal;

import java.util.Map;

public class AnimalPostgresRepository implements AnimalRepository {
    @Override
    public Animal findOne(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, Animal> findAll() {
        return null;
    }

    @Override
    public void add(Animal animal) {

    }

    @Override
    public void remove(Integer idToRemove) {

    }

    @Override
    public void update(Integer animalId, Animal animal) {

    }
}
