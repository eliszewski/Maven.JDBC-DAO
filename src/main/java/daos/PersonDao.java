package daos;

import models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDao implements PersonDaoInterface{
    Connection connection = ConnectionFactory.getConnection();

    public Person extractPersonFromResultSet(ResultSet rs) throws SQLException {
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
                return extractPersonFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> findAll() {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Persons");

            List<Person> persons= new ArrayList<>();

            while(rs.next())
            {
                Person person = extractPersonFromResultSet(rs);
                persons.add(person);
            }

            return persons;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Person dto, int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Persons SET FirstName=?, LastName=?, Age=?, Job=? WHERE id=?;");
            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setInt(3,dto.getAge());
            ps.setString(4, dto.getJob());
            ps.setInt(5,dto.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean create(Person dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Persons (FirstName, LastName, Age, Job) " +
                    "VALUES (?, ?, ?, ?);");
            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setInt(3,dto.getAge());
            ps.setString(4, dto.getJob());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Persons WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
