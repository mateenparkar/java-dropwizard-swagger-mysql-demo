package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.OrderValidator;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private OrderValidator orderValidator = new OrderValidator();
    public List<Order> getAllOrders() throws FailedToGetOrdersException {
        try{
            List<Order> orderList = orderDao.getAllOrders();

            return orderList;
        }catch(SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }
    }

    public Order getOrderByID(int id) throws FailedToGetOrdersException, ProductDoesNotExistException {
        try{
            Order order = orderDao.getOrderByID(id);

            if(order == null){
                throw new ProductDoesNotExistException();
            }
            return order;


        }catch(SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }
    }

    public int createOrder(OrderRequest orderRequest) throws FailedToCreateProductException, InvalidProductException {
        try{
            String validation = orderValidator.isValidOrder(orderRequest);

            if(validation != null){
                throw new InvalidProductException(validation);
            }
            int id = orderDao.createOrder(orderRequest);

            if(id == -1){
                throw new FailedToCreateProductException();
            }
            return id;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToCreateProductException();
        }
    }

    public void updateProduct(int id, OrderRequest orderRequest) throws InvalidProductException, ProductDoesNotExistException, FailedToUpdateProductException {
        try{
            String validation = orderValidator.isValidOrder(orderRequest);

            if(validation != null){
                throw new InvalidProductException(validation);
            }

            Order orderToUpdate = orderDao.getOrderByID(id);

            if(orderToUpdate == null){
                throw new ProductDoesNotExistException();
            }

            orderDao.updateOrder(id, orderRequest);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToUpdateProductException();
        }
    }

    public void deleteOrder(int id) throws ProductDoesNotExistException, FailedToDeleteProductException {
        try{
            Order productToDelete = orderDao.getOrderByID(id);

            if(productToDelete == null){
                throw new ProductDoesNotExistException();
            }
            orderDao.deleteOrder(id);
        }catch(SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToDeleteProductException();
        }
    }
}
