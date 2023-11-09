package ecommerce.donatto.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ecommerce.donatto.model.User;
import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailServiceImpl implements UserDetailsService { //->es una interface

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCrypt; //Para encriptar

    @Autowired
    HttpSession session;

    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //carga el usuario por un metodo
        Optional<User> optionalUser=userService.findByUsername(username);//Declaramos que nos obtenga el usuario a traves del metodo username
        if (optionalUser.isPresent()) {
            session.setAttribute("iduser", optionalUser.get().getId());
            User user = optionalUser.get();
            return null;
           
        } else {
			throw new UsernameNotFoundException("Usuario no encontrado");			
		}
    }
}
