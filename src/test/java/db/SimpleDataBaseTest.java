package db;

import org.junit.*;
import utils.MySQLDBManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static db.Pet.addSuffix;
import static db.Pet.getQuery;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class SimpleDataBaseTest {

    Connection connection;

    @Before
    public void setup() throws IOException, SQLException {
        connection = MySQLDBManager.createConnection();
        try {
            MySQLDBManager.executeUpdate("queries/drop_pet_table.sql");
            MySQLDBManager.executeUpdate("queries/create_pet_table.sql");
            //MySQLDBManager.executeUpdate("queries/add_pet_records.sql");

            PreparedStatement preparedStatement = getQuery(connection,
                    Pet.builder()
                            .tableName(addSuffix("pet", "Kyiv"))
                    .build());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
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
        //name,owner,species, sex, birth, death

        while (resultSet.next()) {
            String sex = resultSet.getString("sex");
            System.out.println(resultSet.getString("birth"));
            System.out.println(resultSet.getString("death"));
            assertThat(sex, not(isEmptyOrNullString()));
        }
        assertTrue("Table has 0 rows.", resultSet.first());
    }

}
