package ecommerce.donatto.service;

import java.util.List;

import ecommerce.donatto.model.Order;

public interface IOrderService {
    List<Order> findAll();
    Order save (Order order);
    String generateOrderNumber();
}
