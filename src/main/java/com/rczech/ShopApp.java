package com.rczech;

import com.rczech.controler.ControllerProduct;
import com.rczech.domain.Product;
import com.rczech.domain.Warehouse;
import com.rczech.hibernate.HibernateSessionRegistry;
import com.rczech.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {


        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        MySqlRepositoryProduct mySqlRepositoryProduct =
                new MySqlRepositoryProduct(session);
        ControllerProduct controllerProduct =
                new ControllerProduct(session, mySqlRepositoryProduct);

        // save product -- start
        String name = "plasytation 5";
        String catalogNumber = "QW3RTY";

        Integer productId = controllerProduct
                .create(name, catalogNumber);

        Product product = controllerProduct.find(productId);
        System.out.println(product);

        String description = "fresh and funky";
        controllerProduct.changeDescription(productId, description);

        controllerProduct.delete(productId);


        //###

        try {
            session.getTransaction().begin();

            String nameW = "11WarehouseOne";
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
        HibernateSessionRegistry.shutdown();
    }
}
