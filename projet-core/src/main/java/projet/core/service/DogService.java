package projet.core.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import projet.core.dao.DogDAO;
import projet.core.entity.Dog;

import java.util.List;

@Service
@Transactional
public class DogService extends GenericService<Dog>{

    private final DogDAO dogDAO;

    protected DogService(DogDAO dogDAO) {
        super(dogDAO);
        this.dogDAO = dogDAO;
    }

    public List<Dog> findAll() {
        return dogDAO.findAll();
    }

    public Dog findByName(String dogName) {
        return dogDAO.findDogsByName(dogName);
    }

    public Dog findById(long id) {
        return dogDAO.findDogsById(id);
    }

    public Dog create(Dog dog) {
        return dogDAO.save(dog);
    }

    public void deleteDog(long dogId) {
        dogDAO.deleteById(dogId);
    }

}