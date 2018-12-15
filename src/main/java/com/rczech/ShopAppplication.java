package com.rczech;

import java.sql.*;

public class ShopAppplication {

    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    // wywolać query - bez parametrów (Statement)
    // odczyt wyników
    // zamknąć statement

    public void findAllProducts(Connection connection) {
        try {
            statement = connection.createStatement();
            resultSet = statement.
                    executeQuery("SELECT product_id, catalog_number, name, description FROM PRODUCTS");
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String catalogNumber=resultSet.getString("catalog_number");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                System.out.println(
                        "Product with id: " + id +
                                " and catalog_number: " + catalogNumber +
                                " and name: " + name +
                                " and description: " + description + "."
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public void insertProducts(Connection connection) {

        int id;
        String catalog_number;
        String name;
        String description;

        try {
            statement=connection.createStatement();
            String sql = "INSERT INTO Products " +
                    "VALUES (5, '12345', 'Ali', '18')";


            statement.executeUpdate(sql);
            System.out.println("You inserted: " + sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

