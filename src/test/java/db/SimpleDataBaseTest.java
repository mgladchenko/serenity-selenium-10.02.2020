package db;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import utils.MySQLDBManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleDataBaseTest {

    //ToDo: support SQL parametrisation

    Connection connection;

    @Before
    public void setup() throws IOException, SQLException {
        connection = MySQLDBManager.createConnection();
        try {
            MySQLDBManager.executeUpdate("queries/drop_pet_table.sql");
            MySQLDBManager.executeUpdate("queries/create_pet_table.sql");
            MySQLDBManager.executeUpdate("queries/add_pet_records.sql");
        } catch (Exception e) {
            System.out.println("Table does not exist.");
        }
    }

    @After
    public void closeDBConnection() throws SQLException {
        MySQLDBManager.closeConnection(connection);
    }

    @Test
    public void dbTest() throws SQLException, IOException {
        ResultSet resultSet = MySQLDBManager.executeQuery("queries/select_all_from_pet.sql");
        Assert.assertTrue("Table has 0 rows.", resultSet.first());



        //ToDo:
    }
}
