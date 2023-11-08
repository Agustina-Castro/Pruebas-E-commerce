package ecommerce.donatto.service;

import java.util.Optional;

import ecommerce.donatto.model.User;

public interface IUserService {
    Optional<User> findById(Integer id);
    User save (User user);
}
