package zoo.animal.service;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;
import zoo.animal.repository.AnimalInMemoryRepository;
import zoo.animal.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static zoo.animal.repository.AnimalInMemoryRepository.UNKNOWN_ANIMAL;

/**
 * Created by tomic on 10.06.18.
 */
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public Animal findOne(Integer id) {
        return repository.findOne(id);
    }

    public Map<Integer, Animal> findAll() {
        return repository.findAll();
    }

    public void add(Animal animal) {
        repository.add(animal);
    }

    public void remove(Integer idToRemove) {
        repository.remove(idToRemove);
    }

    public void update(Integer animalId, Animal animal) {
        repository.update(animalId, animal);
    }


}
