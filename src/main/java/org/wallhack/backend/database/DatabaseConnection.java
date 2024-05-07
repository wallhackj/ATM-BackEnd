package org.wallhack.backend.database;

import lombok.Getter;
import lombok.Synchronized;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        String url = "";
        String user = "postgres";
        String password = "";
        connection = DriverManager.getConnection(url, user, password);
    }

    @Synchronized
    public static DatabaseConnection getInstance() {
        try {
            if (instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null) {
                        instance = new DatabaseConnection();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return instance;
    }

}
