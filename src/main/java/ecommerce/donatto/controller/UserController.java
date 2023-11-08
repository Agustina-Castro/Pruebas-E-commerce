package ecommerce.donatto.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.donatto.model.User;
import ecommerce.donatto.service.IUserService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserService userService;

    //usuario-registro
    @GetMapping("/register")
    public String create() {
        return "user/registro";
    }

    @PostMapping("/save")
    public String save(User user) {
        logger.info("Usuario registro: {}", user);
        user.setType("USER");
        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/inicioSesion";
    }

    @PostMapping("/acceder")
    public String acceder(User user, HttpSession session) { //user user parametro
        logger.info("Accesos : {}", user);//imprimimos por consola

        //pasamos el atributo que es username
        Optional<User> usuario=userService.findByUsername(user.getUsername());
        //logger.info("Usuario obtenido de db: {}", usuario.get());
        
        if (usuario.isPresent()) { //Optional nos permite hacer la validacion de existencia del user
            session.setAttribute("iduser", usuario.get().getId());//Si esta presente añadimo un objeto http session
            //Mantendremos la session mientras exista el usuario
            if (usuario.get().getType().equals("ADMIN")) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        } else {
            logger.info("Usuario no existe");
        }

        return "redirect:/";
    }

}
