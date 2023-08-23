package org.kainos.ea.db;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int check(OrderRequest orderRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT COUNT(CustomerID) FROM Customer WHERE CustomerID=" + orderRequest.getCustomerID());
        rs.next();

        int count = rs.getInt(1);

        return count;


    }
}
