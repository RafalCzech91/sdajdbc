package com.rczech.controler;

import com.rczech.domain.Product;
import com.rczech.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ControllerProduct {
    private final Session session;
    private final MySqlRepositoryProduct mySqlRepositoryProduct;

    public ControllerProduct(
            Session session,
            MySqlRepositoryProduct mySqlRepositoryProduct) {
        this.session = session;
        this.mySqlRepositoryProduct = mySqlRepositoryProduct;
    }

    public Integer create(String name, String catalogNumber) {
        Product product = new Product(name, catalogNumber);
        Integer id = null;

        try {
            session.getTransaction().begin();

            id = mySqlRepositoryProduct.save(product);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        }

        return id;
    }

    public Product find(Integer productId) {
        return mySqlRepositoryProduct.findById(productId);
    }

    public void changeDescription(Integer productId, String description) {
        Product product = find(productId);
        product.changeDescription(description);

        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.update(product);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();

        }


    }

    public void delete(Integer productId) {
        Product product = find(productId);

        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.delete(product);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();

        }

    }
}