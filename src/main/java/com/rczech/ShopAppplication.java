package com.rczech;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopAppplication {

    Statement statement = null;
    ResultSet resultSet = null;

    public void findAllProducts(Connection connection) {

        try {
            statement = connection.createStatement();
            resultSet = statement.
                    executeQuery("SELECT product_id, name, description FROM PRODUCTS");
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                System.out.println(
                        "Product with id: " + id +
                                " and name: " + name +
                                " and description: " + description + "."
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        // wywolać query - bez parametrów (Statement)
        // odczyt wyników
        // zamknąć statement
    }
}
