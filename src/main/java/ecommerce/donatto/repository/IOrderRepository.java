package ecommerce.donatto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.donatto.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{
    
}
