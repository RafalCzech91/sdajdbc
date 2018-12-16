package com.rczech.repository;

import com.rczech.domain.Product;
import org.hibernate.Session;

public class MySqlRepositoryProduct {
    private Session session;

    public MySqlRepositoryProduct(Session session) {

        this.session = session;
    }

    public Integer save(Product product) {
        return (Integer) session.save(product);
    }
}
