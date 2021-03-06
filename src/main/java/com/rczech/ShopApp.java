package com.rczech;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class ShopApp {

    static final String DB_URL = "jdbc:mysql://localhost/product";
    static final String USER = "rafael";
    static final String PASS = "zaq12wsx";

    Connection connection = null;
    Statement statement = null;


    public static void main(String[] args) {

               //register mysql driver
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (
                SQLException e) {
            e.printStackTrace();
            // we should not continue
        }

        //establish connection
        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        //query execution
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE PRODUCTS " +
                            "SET DESCRIPTION = ? WHERE PRODUCT_ID = ?"
            );
            updateProducts(preparedStatement);

            statement = connection.createStatement();
            insertProduct(statement);
            findAllProducts(statement);
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

        //close connection
        try {
            if (connection != null)
                connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }



    public static void updateProducts(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, "bla bla bla");
            preparedStatement.setInt(2, 1);

            int updated = preparedStatement.executeUpdate();

            System.out.println(updated + " updated products.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  insertProduct(Statement statement) {
        try {
            int inserted = statement.executeUpdate(
                    "INSERT INTO PRODUCTS VALUES " +
                            "(1, '123456', 'first product', 'some description')"
            );

            System.out.println(inserted + " new products added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findAllProducts(Statement statement) {
        ResultSet resultSet = null;

        try {
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
