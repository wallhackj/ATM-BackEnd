package org.wallhack.backend.database.authorization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginVerification {
    public static boolean verifyLogin(Data data, Connection connection) throws SQLException {
        String query = "SELECT login_cache, pass_cache FROM authorizations";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String login = resultSet.getString("login_cache");
                String password = resultSet.getString("pass_cache");

                if (data.equals(new Data(login, password))) {
                    return true;
                }
            }
        }
        return false;
    }
}

