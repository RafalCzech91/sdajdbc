package com.rczech.ShoopAppOldFirstApp;

import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static com.rczech.ShoopAppOldFirstApp.ShopApp.*;


public class RunApp {


    public static void main(String[] args) {

        ShopAppplication shopApp = new ShopAppplication();

        Statement statement = null;

        PreparedStatement preparedStatement = null;

        //register driver
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //connection - create
        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String action = null;
        try {
            System.out.println("Please choose action : " +
                    "1 - show one" + " 2 - delete" + " 3 - update" + " 4 - insert" + " 5 - show all"
            );
            action = reader.readLine();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        switch (action) {
            case "1":
                System.out.println("You chose to show one: ");


                break;
            case "2":
                System.out.println("You chose to delete: ");

                break;
            case "3":
                System.out.println("You chose to update: ");


                break;
            case "4":
                System.out.println("You chose to: insert ");
                System.out.println();

                shopApp.insertProducts(preparedStatement);


                break;
            case "5":
                System.out.println("You chose to show all: ");
                System.out.println();
                shopApp.findAllProducts(connection);
                break;
            default:
                System.out.println("Unknown querry");
        }


        // close connection

        try {
            if (connection != null)
                connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}
