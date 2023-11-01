package ecommerce.donatto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descriptio;
    private String image;
    private double price;
    private int cantidad;

    @ManyToOne
    private User user;
    
    public Product() {
    }


    public Product(Integer id, String name, String descriptio, String image, double price, int cantidad, User user) {
        super();
        this.id = id;
        this.name = name;
        this.descriptio = descriptio;
        this.image = image;
        this.price = price;
        this.cantidad = cantidad;
        this.user = user;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product [Id=" + id + ", name=" + name + ", descriptio=" + descriptio + ", image=" + image + ", price="
                + price + ", cantidad=" + cantidad + "]";
    }

}
