package com.rczech.repository.mysql;

import com.rczech.domain.Warehouse;
import org.hibernate.Session;

import java.util.List;

public class MySqlRepositoryWarehouse {
    private Session session;

    public MySqlRepositoryWarehouse(Session session) {
        this.session = session;
    }

    public Integer save(Warehouse warehouse) {
        return (Integer) session.save(warehouse);
    }

    public Warehouse findById(Integer warehouseid) {
        return session.get(Warehouse.class, warehouseid);
    }

    public void update(Warehouse warehouse) {
        session.update(warehouse);
    }

    public void delete(Warehouse warehouse) {
        session.delete(warehouse);

    }

    public List <Warehouse> findAll() {
        return session.createQuery("from Warehouse").list();
    }
}
