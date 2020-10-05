package com.upgrad.eshopApp.services;

import com.upgrad.eshopApp.daos.OrderDAO;
import com.upgrad.eshopApp.entites.Order;
import com.upgrad.eshopApp.entites.Product;
import com.upgrad.eshopApp.exceptions.APIException;
import com.upgrad.eshopApp.exceptions.OrderDetailsNotFoundException;
import com.upgrad.eshopApp.exceptions.OrderFailedException;
import com.upgrad.eshopApp.exceptions.UserDetailsNotFoundException;
import com.upgrad.eshopApp.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service(value ="orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    @Qualifier("bookingDAO")
    private OrderDAO orderDAO  ;
    @Autowired
    UserService userService;
    @Autowired
    OrderValidator orderValidator;
    @Override

    public Order acceptOrderDetails(Order order) throws UserDetailsNotFoundException, OrderFailedException, APIException, ParseException {
        return orderDAO.save(order);
    }

    @Override
    public Order getOrderDetails(int orderId) throws OrderDetailsNotFoundException {
        return orderDAO.findById(orderId).orElseThrow(
                ()->  new OrderDetailsNotFoundException("Details not found for id : " + orderId));
    }

    @Override
    public boolean deleteBooking(int id) throws OrderDetailsNotFoundException {
        Order order = getOrderDetails(id);
        orderDAO.delete(order);
        return true;
    }

    @Override
    public List<Order> getAllOrderDetails() {
        return orderDAO.findAll();
    }
}
