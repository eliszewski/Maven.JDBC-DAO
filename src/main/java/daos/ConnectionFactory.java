package daos;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Connect to Database
 * @author hany.said
 */
public class ConnectionFactory {

    public static final String URL = Login.getUrl();
    public static final String USER = Login.getUsername();
    public static final String PASS = Login.getPassword();

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = daos.ConnectionFactory.getConnection();
        PersonDao dao = new PersonDao();
        System.out.println(dao.findById(1));
        System.out.println(dao.findAll());
    }

}