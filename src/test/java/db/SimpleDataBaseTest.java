package db;

import org.junit.Test;
import utils.MySQLDBManager;

import java.io.IOException;
import java.sql.SQLException;

public class SimpleDataBaseTest {

    @Test
    public void dbTest() throws SQLException, IOException {
        MySQLDBManager.executeQuery("queries/select_all_from_pet.sql");
    }
}
