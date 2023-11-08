package ecommerce.donatto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.donatto.model.Order;
import ecommerce.donatto.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{

    @Autowired //Para que spring sepa que tiene que inyectar el objeto a esta clase de ser
    private IOrderRepository orderRepository;
    
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
    
}
