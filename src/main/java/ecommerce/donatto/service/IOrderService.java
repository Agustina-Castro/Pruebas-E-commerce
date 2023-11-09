package ecommerce.donatto.service;

import java.util.List;

import ecommerce.donatto.model.Order;
import ecommerce.donatto.model.User;

public interface IOrderService {
    List<Order> findAll();
    Order save (Order order);
    String generateOrderNumber();
    List<Order> findByUser (User user);

}
