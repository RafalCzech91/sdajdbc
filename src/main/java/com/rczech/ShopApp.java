package com.rczech;

import com.rczech.domain.Product;
import com.rczech.domain.Warehouse;
import com.rczech.hibernate.HibernateSessionRegistry;
import org.hibernate.Session;

public class ShopApp {

    public static void main(String[] args) {
        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        try {
            session.getTransaction().begin();

            // save product -- start
            String name = "laptop";
            String catalogNumber = "QW132";
            Product product = new Product(name, catalogNumber);

            Integer productId = (Integer) session.save(product);

            //save product -- end

            System.out.println(productId);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

        try {
            session.getTransaction().begin();

            String nameW = "WarehouseOne";
            String street = "Anders";
            String city = "LosAngeles";
            int postalCode = 12345;
            int buildingNumber = 1;
            String country = "Poland";

            Warehouse warehouse = new Warehouse(nameW, street, city, postalCode, buildingNumber, country);

            Integer warehouseid = (Integer) session.save(warehouse);

            System.out.println(warehouseid);


            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
}
