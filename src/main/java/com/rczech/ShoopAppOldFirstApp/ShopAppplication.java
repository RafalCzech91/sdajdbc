package com.rczech.ShoopAppOldFirstApp;

import java.sql.*;
import java.util.Scanner;

public class ShopAppplication {

    static final String DB_URL = "jdbc:mysql://localhost/product";
    static final String USER = "rafael";
    static final String PASS = "zaq12wsx";

    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Scanner scanner = new Scanner(System.in);

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
                String catalogNumber = resultSet.getString("catalog_number");
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

    public void insertProducts(PreparedStatement preparedStatement) {

        System.out.println("Please enter product_id, catalog_number, name, description: ");
        System.out.println();
        int id = scanner.nextInt();
        String catalog_number = scanner.next();
        String name = scanner.next();
        String description = scanner.next();

        try {

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO Products " +
                            " VALUES (product_id = ?, catalog_number = ?, name = ?, description = ?)"
            );

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, catalog_number);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, description);

            int inserted = preparedStatement.executeUpdate();

            System.out.println(inserted + " updated products.");

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//try {
//        statement=connection.createStatement();
//        String sql = "INSERT INTO Products " +
//        "VALUES (5, '12345', 'Ali', '18')";
//
//
//        statement.executeUpdate(sql);
//        System.out.println("You inserted: " + sql);
//
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
