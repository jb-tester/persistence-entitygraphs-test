package com.mytests.jpa.entityGraphTests.repositories;


import com.mytests.jpa.entityGraphTests.data.Customer;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 **
 * <p>Created by irina on 16.05.2021.</p>
 * <p>Project: spring-m2m-entitygraphs-test</p>
 **
 */


public class CustomersRepo {

    private EntityManagerFactory emf = null;

    public CustomersRepo() {
        Map properties = new HashMap();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        emf = Persistence.createEntityManagerFactory("entity-graph-pu", properties);  
    }

    
    public List<Customer> findWithDefaultNamedEntityGraph(){
        EntityManager entityManager = emf.createEntityManager();
        EntityGraph entityGraph = entityManager.getEntityGraph("Customer");
        
        
        List<Customer> list = entityManager.createQuery("select c from Customer c where c.vip = true ")
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();

        entityManager.close();
        return list; 
    }
    public void clean() {
        emf.close();
    }
}
