package com.rczech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunApp {

    public static void main(String[] args) {

        ShopApp shopApp = new ShopApp();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String action = null;
        try {
            System.out.print("Please choose action : " +
                    "1 - show one" + " 2 - delete" + " 3 - update" + " 4 - add" + " 5 - show all"
            );
            action = reader.readLine();

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
                    System.out.println("You chose to: add ");

                    break;
                case "5":
                    System.out.println("You chose to show all: ");

                    break;
                default:
                    System.out.println("Unknown querry");
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
