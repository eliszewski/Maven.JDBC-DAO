package daos;

import models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDao implements PersonDaoInterface{
    Connection connection = ConnectionFactory.getConnection();

    public Person extractCarsFromResultSet(ResultSet rs) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("ID"));
        person.setLastName(rs.getString("LastName"));
        person.setFirstName(rs.getString("FirstName"));
        person.setAge(rs.getInt("Age"));
        person.setJob(rs.getString("Job"));
        return person;
    }

    @Override
    public Person findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Persons WHERE id = " + id + ";");

            if (rs.next()){
                return extractCarsFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
