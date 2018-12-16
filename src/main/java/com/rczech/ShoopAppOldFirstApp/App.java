package com.rczech.ShoopAppOldFirstApp;

import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class App {

    static final String DB_URL = "jdbc:mysql://localhost/product";
    static final String USER = "rafael";
    static final String PASS = "zaq12wsx";

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username = null;
        try {
            System.out.print("Please enter user name : ");
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(username);


        //register mysql driver

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
            //we should not continue
        }

        //establish connection
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //query execution
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "update products " + "set description = ? where product_id = ?"
            );
            updateProducts(preparedStatement);
            statement = connection.createStatement();

            insertProduct(statement);
            findAllProdcuts(statement);
            showProducts(statement);
            deleteProducts(statement);



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void deleteProducts(Statement statement) {

//        PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where id=?");
//        preparedStatement.setInt(1,101);
//
//        int i=preparedStatement.executeUpdate();
//        System.out.println(i+" records deleted");

    }

    private static void showProducts(Statement statement) {


    }

    private static void updateProducts(PreparedStatement preparedStatement) {

        try {
            preparedStatement.setString(1, "blablabla");
            preparedStatement.setInt(2, 1);

            int updated = preparedStatement.executeUpdate();

            System.out.println(updated + " updated produect.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void insertProduct(Statement statement) {

        try {

            int inserted = statement.executeUpdate(
                    "insert into products values " +
                            "(1, 123456, 'first product', 'null')"
            );

            System.out.println(inserted + " new products added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findAllProdcuts(Statement statement) {
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery("SELECT product_id, name FROM PRODUCTS");

            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("name");

                System.out.println(
                        "Product with id: " + id + " and name: " + name + "."
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
