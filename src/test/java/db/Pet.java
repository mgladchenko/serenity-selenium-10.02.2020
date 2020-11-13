package db;

import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Builder
@Getter
public class Pet {

    @Builder.Default
    private String tableName = "pet";
    @Builder.Default
    private String name = "Dog";
    @Builder.Default
    private String owner = "John";
    @Builder.Default
    private String species = "red";
    @Builder.Default
    private String sex = "m";
    @Builder.Default
    private String birth = "2001-02-20";
    private String death;

    public static String addSuffix(String originalString, String suffix) {
        return originalString+suffix;
    }

    @SneakyThrows
    public static PreparedStatement getQuery(Connection connection, Pet pet) {
        //INSERT INTO pet VALUES ('Dog','John','red','m','2001-02-20', CURRENT_TIMESTAMP);
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO "+pet.getTableName()+" VALUES (?,?,?,?,?, CURRENT_TIMESTAMP);");
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setString(2, pet.getOwner());
        preparedStatement.setString(3, pet.getSpecies());
        preparedStatement.setString(4, pet.getSex());
        preparedStatement.setString(5, pet.getBirth());
        return preparedStatement;
    }


}
