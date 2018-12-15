package com.rczech;

import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.rczech.ShopApp.DB_URL;
import static com.rczech.ShopApp.PASS;
import static com.rczech.ShopApp.USER;


public class RunApp {

    public static void main(String[] args) {

        ShopApp shopApp = new ShopApp();

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
            System.out.print("Please choose action : " +
                    "1 - show one" + " 2 - delete" + " 3 - update" + " 4 - add" + " 5 - show all"
            );
            action = reader.readLine();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        switch (action) {
            case "1":
                System.out.println("You chose to show one: ");
                //shopApp.displayProduct();


                break;
            case "2":
                System.out.println("You chose to delete: ");

                break;
            case "3":
                System.out.println("You chose to update: ");


                break;
            case "4":
                System.out.println("You chose to: add ");

                break;
            case "5":
                System.out.println("You chose to show all: ");

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
