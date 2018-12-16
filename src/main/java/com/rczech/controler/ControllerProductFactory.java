package com.rczech.controler;

import com.rczech.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ControllerProductFactory {

    public ControllerProductFactory(Session session) {
        MySqlRepositoryProduct mySqlRepositoryProduct =
                new MySqlRepositoryProduct(session);
        ControllerProduct controllerProduct =
                new ControllerProduct(session, mySqlRepositoryProduct);
    }
}
