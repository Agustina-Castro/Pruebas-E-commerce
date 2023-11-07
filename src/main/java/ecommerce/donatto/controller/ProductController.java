package ecommerce.donatto.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import ecommerce.donatto.model.Product;
import ecommerce.donatto.model.User;
import ecommerce.donatto.service.ProductService;
import ecommerce.donatto.service.UploadFileService;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product, @RequestParam("file") MultipartFile image) throws IOException {
        LOGGER.info("Este es el objeto producto {}",product);
        User u=new User(1,"","","","","","");
        product.setUser(u);

        //imagen
        if (!image.isEmpty()) { // cuando se crea un producto
            //Path directorioImagenes = Paths.get("src//main//resources//static/images");
            //String rutaAbs = directorioImagenes.toFile().getAbsolutePath();
            String rutaAbs = "C:\\Users\\Usuario\\Desktop\\e-commerce\\backend\\donatto\\uploads";

            try {
                byte[] bytesImg = image.getBytes();
                Path rutaCompleta = Paths.get(rutaAbs +"//"+image.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                product.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } 

        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = new Product();
        Optional<Product> optionalProduct=productService.get(id);
        product=optionalProduct.get();

        LOGGER.info("Producto buscado: {}",product);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product, @RequestParam("file") MultipartFile file) throws IOException {
        Product p = new Product();
        p=productService.get(product.getId()).get();
        
        if (file.isEmpty()) { // editamos el producto sin cambiar imag
            
            product.setImage(p.getImage());
        }else { //editar imagen
            //Eliminar cuando no sea la imagen por defecto
            if (!p.getImage().equals("default.jpg")) {
                upload.deleteImage(p.getImage());
            }
        }
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Product p = new Product();
        p=productService.get(id).get();

        //Eliminar cuando no sea la imagen por defecto
        if (!p.getImage().equals("default.jpg")) {
            upload.deleteImage(p.getImage());
        }

        productService.delete(id);
        return "redirect:/products";
    }

}
