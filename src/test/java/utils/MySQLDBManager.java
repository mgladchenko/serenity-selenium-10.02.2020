package utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDBManager {

    private MySQLDBManager() {
    }

    private final static String USER_NAME = "dSjZMHRKud";
    private final static String USER_PASS = "LXxp9vVVyB";
    private final static String SERVER_NAME = "remotemysql.com";
    private final static int SERVER_PORT = 3306;
    private final static String DB_NAME = "dSjZMHRKud";


    public static Connection createConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(USER_PASS);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setPort(SERVER_PORT);
        dataSource.setDatabaseName(DB_NAME);

        return dataSource.getConnection();
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private static String getQueryFromFile(String filePath) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    public static ResultSet executeQuery(String filePath) throws SQLException, IOException {
        Connection connection = createConnection();
        String query = getQueryFromFile(filePath);
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        return resultSet;
    }

    public static int executeUpdate(String filePath) throws SQLException, IOException {
        Connection connection = createConnection();
        String query = getQueryFromFile(filePath);
        int affectedRowsNumber = connection.createStatement().executeUpdate(query);
        System.out.println("Exit code: " + affectedRowsNumber);
        return affectedRowsNumber;
    }

}
