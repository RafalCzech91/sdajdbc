package com.rczech;

import com.rczech.controler.ControllerProduct;
import com.rczech.controler.ControllerProductFactory;
import com.rczech.controler.ControllerWarehouse;
import com.rczech.domain.Product;
import com.rczech.domain.Warehouse;
import com.rczech.hibernate.HibernateSessionRegistry;
import com.rczech.repository.mysql.MySqlRepositoryWarehouse;
import com.rczech.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {


        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        ControllerProductFactory factory = new ControllerProductFactory(session);

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

        String nameW = "11WarehouseOne";
        String street = "Anders";
        String city = "LosAngeles";
        int postalCode = 12345;
        int buildingNumber = 1;
        String country = "Poland";

        MySqlRepositoryWarehouse mySqlRepositoryWarehouse =
                new MySqlRepositoryWarehouse(session);
        ControllerWarehouse controllerWarehouse =
                new ControllerWarehouse(session, mySqlRepositoryWarehouse);

        Integer warehouseid = controllerWarehouse.create(nameW, street, city, postalCode, buildingNumber, country);

        System.out.println(warehouseid);

        Warehouse warehouse = controllerWarehouse.find(warehouseid);
        System.out.println(warehouse);

        controllerWarehouse.delete(warehouseid);



        session.close();
        HibernateSessionRegistry.shutdown();
    }
}
