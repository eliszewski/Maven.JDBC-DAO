package daos;

import models.Person;

import java.sql.Connection;
import java.util.List;

public class PersonDao implements PersonDaoInterface{
    Connection connection = ConnectionFactory.getConnection();

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public boolean update(Person dto, int id) {
        return false;
    }

    @Override
    public boolean create(Person dto) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
