package ecommerce.donatto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.donatto.model.Order;
import ecommerce.donatto.model.OrderDetail;
import ecommerce.donatto.model.Product;
import ecommerce.donatto.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;

    //Para almacenar los detallesde la orden
    List<OrderDetail> detail = new ArrayList<OrderDetail>();
    
    //Datos de la orden
    Order order = new Order();

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("products", productService.findAll());

        return "user/home";
    }

    @GetMapping("producthome/{id}")
    public String productHome(@PathVariable Integer id, Model model) {
        log.info("id enviado como parametro {}",id);
        Product product = new Product();
        Optional<Product> productOptional = productService.get(id);
        product = productOptional.get();

        model.addAttribute("product", product);

        return "user/producthome";
    }

    @PostMapping("/cart") 
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {//entre (argumentos) 
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        double sumaTotal = 0;

        Optional<Product> optionalProduct = productService.get(id);
        log.info("Producto añadido {}", optionalProduct.get());
        log.info("cantidad: {}", cantidad);
        product=optionalProduct.get();

        orderDetail.setCantidad(cantidad);
        orderDetail.setPrice(product.getPrice());
        orderDetail.setName(product.getName());
        orderDetail.setTotal(product.getPrice()*cantidad);
        orderDetail.setProduct(product);

        //validacion para que no se agregue un prod mas de una vez
         Integer idProduct=product.getId();
         boolean ingresado=detail.stream().anyMatch(p -> p.getProduct().getId()==idProduct);//anyMatch busca coincidencias

         if (!ingresado) {
            detail.add(orderDetail);
         }

        sumaTotal=detail.stream().mapToDouble(dt->dt.getTotal()).sum();

        order.setTotal(sumaTotal);
        model.addAttribute("cart", detail);
        model.addAttribute("order", order);

        return "user/cart";
    }

    //Quitar producto
    @GetMapping("/delete/cart/{id}")
    public String deleteProductCart(@PathVariable Integer id, Model model) {
        //Lista nueva de detalles
        List<OrderDetail> ordersNew = new ArrayList<OrderDetail>();

        for(OrderDetail orderDetail: detail) {
            if (orderDetail.getProduct().getId()!=id) {
                ordersNew.add(orderDetail);
            }
        }
        //mostrar lista actualizada con los prod restantes
        detail=ordersNew;

        double sumaTotal=0;
        sumaTotal=detail.stream().mapToDouble(dt->dt.getTotal()).sum();

        order.setTotal(sumaTotal);
        model.addAttribute("cart", detail);
        model.addAttribute("order", order);

        return "user/cart";
    }

    @GetMapping("/getCart")
    public String getCart(Model model) {

        model.addAttribute("cart", detail);
        model.addAttribute("order", order);

        return "/user/cart";
    }
    
}
