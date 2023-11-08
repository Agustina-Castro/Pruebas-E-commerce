package ecommerce.donatto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.donatto.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    
}
