package ecommerce.donatto.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String number;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;

    public Order() {
    }

    public Order(Integer id, String number, Date fechaCreacion, Date fechaRecibida, double total) {
        this.id = id;
        this.number = number;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order [Id=" + id + ", number=" + number + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida="
                + fechaRecibida + ", total=" + total + "]";
    }

}