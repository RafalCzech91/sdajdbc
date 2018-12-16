package com.rczech.controler;

import com.rczech.domain.Owner;
import com.rczech.domain.Sex;
import com.rczech.domain.Warehouse;
import com.rczech.repository.mysql.MySqlRepositoryWarehouse;
import org.hibernate.Session;

public class ControllerWarehouse {
    private final Session session;
    private final MySqlRepositoryWarehouse mySqlRepositoryWarehouse;

    public ControllerWarehouse(
            Session session,
            MySqlRepositoryWarehouse mySqlRepositoryWarehouse) {
        this.session = session;
        this.mySqlRepositoryWarehouse = mySqlRepositoryWarehouse;
    }

    public Integer create(String nameW, String street, String city, int postalCode, int buildingNumber, String country) {

        Warehouse warehouse = new Warehouse(nameW, street, city, postalCode, buildingNumber, country, new Owner("tom", Sex.MALE));
        Integer id = null;

        try {
            session.getTransaction().begin();

            id = mySqlRepositoryWarehouse.save(warehouse);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

        return id;
    }

    public Warehouse find(Integer warehouseid) {

        return mySqlRepositoryWarehouse.findById(warehouseid);
    }

    public void delete(Integer warehouseid) {
        Warehouse warehouse = find(warehouseid);

        try {
            session.getTransaction().begin();

            mySqlRepositoryWarehouse.delete(warehouse);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();

        }

    }
}
