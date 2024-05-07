package org.wallhack.backend;

import org.wallhack.backend.database.authorization.Data;
import org.wallhack.backend.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.wallhack.backend.database.authorization.LoginVerification.verifyLogin;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();




        try {
            // Obțineți instanța singleton a conexiunii la baza de date
          //  System.out.println(verifyLogin(user1, connection));


            // Utilizați conexiunea pentru a executa o interogare și a afișa rezultatele
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                // Afișați informațiile dorite sau realizați alte operații cu datele
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName);
            }

            // Închideți resursele
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + super.hashCode();
        return result;
    }
}
