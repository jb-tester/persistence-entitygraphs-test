package com.mytests.jpa.entityGraphTests.data;

import javax.persistence.*;
import java.util.List;

/**
 **
 * <p>Created by irina on 16.05.2021.</p>
 * <p>Project: spring-m2m-entitygraphs-test</p>
 **
 */
@Entity
@Table(name="orders", schema = "shop")
public class Orders {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @OneToMany(mappedBy = "orders")
    private List<OrderItems> orderItems;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customers;

    @Basic
    @Column(name = "urgent")
    private Boolean urgent;
    
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItemsByOrderId) {
        this.orderItems = orderItemsByOrderId;
    }
   
    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customersByCustomerId) {
        this.customers = customersByCustomerId;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }
}
