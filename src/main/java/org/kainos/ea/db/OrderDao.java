package org.kainos.ea.db;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderDao {
   private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Order> getAllOrders() throws SQLException{
        Connection c = databaseConnector.getConnection();
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT ORDERID, CustomerID, OrderDate FROM `Order`;");

            List<Order> orderList = new ArrayList<>();

            while(rs.next()){
                Order order = new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("CustomerID"),
                        rs.getDate("OrderDate")
                );
                orderList.add(order);
            }
            return orderList;
        }

    public Order getOrderByID(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT ORDERID, CustomerID, OrderDate FROM `Order` WHERE ORDERID=" + id);

        while(rs.next()){
            return new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );
        }
        return null;
    }

    public int createOrder (OrderRequest orderRequest) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO `Order`(CustomerID, OrderDate) VALUES (?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, orderRequest.getCustomerID());
        st.setDate(2, orderRequest.getOrderDate());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateOrder(int id, OrderRequest orderRequest) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE `Order` SET CustomerID = ?, OrderDate = ? WHERE OrderID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, orderRequest.getCustomerID());
        st.setDate(2, orderRequest.getOrderDate());
        st.setDouble(3,id);

        st.executeUpdate();
    }

    public void deleteOrder(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String deleteStatement = "DELETE FROM `Order` WHERE ORDERID = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1, id);

        st.executeUpdate();
    }
}

