package ecommerce.donatto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.donatto.model.Product;
import ecommerce.donatto.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home(Model model){

        List<Product> products=productService.findAll();
        model.addAttribute("products", products);

        return "administrador/home";
    }

}
