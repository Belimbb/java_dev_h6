package org.example;

import org.example.serviceClasses.FileService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void populateDatabase() throws SQLException {
        String filePath = "C:\\Users\\PC\\Documents\\GitHub\\java_dev_h6\\src\\main\\resources\\sql\\populate_db.sql";
        String dbRequest = FileService.getFileContent(filePath);

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(dbRequest);
    }
}
