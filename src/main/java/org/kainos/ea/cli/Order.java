package org.kainos.ea.cli;
import java.util.Date;
public class Order implements Comparable<Order> {
    private int orderID;
    private int customerID;

    public Order(int orderID, int customerID, Date orderDate) {
//        this.orderID = orderID;
//        this.customerID = customerID;
//        this.orderDate = orderDate;

        setOrderID(orderID);
        setCustomerID(customerID);
        setOrderDate(orderDate);
    }

    private Date orderDate;


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString(){
        return "Order ID " + this.getOrderID() + ", Customer iD " + this.getCustomerID() + ", orderDate" + this.getOrderDate();
    }


    @Override
    public int compareTo(Order o) {
        return this.getOrderDate().compareTo(o.getOrderDate());
    }
}
