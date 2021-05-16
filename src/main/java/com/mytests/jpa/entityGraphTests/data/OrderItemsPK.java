package com.mytests.jpa.entityGraphTests.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 **
 * <p>Created by irina on 16.05.2021.</p>
 * <p>Project: spring-m2m-entitygraphs-test</p>
 **
 */
@Embeddable
public class OrderItemsPK implements Serializable {
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "item_id")
    private Integer itemId;

    
    public Integer getOrderId() {
        return orderId;
    }
    
    public Integer getItemId() {
        return itemId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    
}
