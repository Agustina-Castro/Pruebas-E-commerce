package ecommerce.donatto.model;

public class Product {
    private Integer id;
    private String name;
    private String descriptio;
    private String image;
    private double price;
    private int cantidad;
    
    public Product() {
    }

    public Product(Integer id, String name, String descriptio, String image, double price, int cantidad) {
        this.id = id;
        this.name = name;
        this.descriptio = descriptio;
        this.image = image;
        this.price = price;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Product [Id=" + id + ", name=" + name + ", descriptio=" + descriptio + ", image=" + image + ", price="
                + price + ", cantidad=" + cantidad + "]";
    }

    
}
