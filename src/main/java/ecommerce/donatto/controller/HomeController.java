package ecommerce.donatto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.donatto.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("products", productService.findAll());

        return "user/home";
    }
}
