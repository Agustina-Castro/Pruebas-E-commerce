package ecommerce.donatto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.donatto.model.User;
import ecommerce.donatto.repository.IUserRepository;

@Service //clase
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
}
