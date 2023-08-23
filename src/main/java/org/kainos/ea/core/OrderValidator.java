package org.kainos.ea.core;

import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.db.CustomerDao;

import java.sql.SQLException;

public class OrderValidator {
    private CustomerDao customerDao = new CustomerDao();
    public String isValidOrder(OrderRequest orderRequest) throws SQLException {
        if(customerDao.check(orderRequest) == 0){
            return "CustomerID doesn't exist in table";
        }
return null;
    }
}
