package com.mytests.jpa.entityGraphTests;

import com.mytests.jpa.entityGraphTests.data.Customer;
import com.mytests.jpa.entityGraphTests.repositories.CustomersRepo;

/**
 **
 * <p>Created by irina on 16.05.2021.</p>
 * <p>Project: persistence-entitygraphs-test</p>
 **
 */
public class RunMe {
    

    public static void main(String[] args) {
        CustomersRepo repo = new CustomersRepo();
        for (Customer customers : repo.findWithDefaultNamedEntityGraph()) {
            System.out.println(customers);
        }
        repo.clean();
    }
}
