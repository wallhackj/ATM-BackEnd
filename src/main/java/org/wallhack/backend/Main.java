package org.wallhack.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "";
        String user = "postgres";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                int postalCode = resultSet.getInt("postal_code");
                String phone = resultSet.getString("phone");
                String sex = resultSet.getString("sex");
                String birthDay = resultSet.getString("birthDay");
                long idnp = resultSet.getLong("idnp");
                String registerDate = resultSet.getString("register_date");

                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName +
                        ", Email: " + email + ", Street: " + street + ", City: " + city +
                        ", Region: " + region + ", Postal Code: " + postalCode + ", Phone: " + phone +
                        ", Sex: " + sex + ", BirthDay: " + birthDay + ", IDNP: " + idnp +
                        ", Register Date: " + registerDate);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Închiderea resurselor
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
