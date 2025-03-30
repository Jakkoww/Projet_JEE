package projet.core.dao;

import projet.core.entity.Dog;

public interface DogDAO extends GenericDAO<Dog>{
    Dog findDogsByName(String name);

    Dog findDogsById(long id);
}
