package daos;

import models.Person;

import java.util.List;
import java.util.Set;

public interface PersonDaoInterface {
    public Person findById(int id);

    public List<Person> findAll();

    public boolean update(Person dto, int id);

    public boolean create(Person dto);

    public boolean delete(int id);
}
