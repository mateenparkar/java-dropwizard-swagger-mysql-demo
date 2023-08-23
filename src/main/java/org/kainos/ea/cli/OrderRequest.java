package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class OrderRequest {
    @JsonCreator
    public OrderRequest(@JsonProperty("CustomerID") int customerID, @JsonProperty("orderDate") Date orderDate) {
        this.CustomerID = customerID;
        this.OrderDate = orderDate;
    }

    private int CustomerID;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public java.sql.Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    private Date OrderDate;
}
