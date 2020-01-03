package com.baufest.Libreria.models;

import com.baufest.Libreria.service.ProductoService;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Compra {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name="factura")
    Factura factura;

    //Integer id_renglon

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @OneToOne
    @JoinColumn(name="producto")
    private Producto producto;

    @Transient
    Integer productoId;

    public Compra(@JsonProperty("cantidad") Integer cantidad, @JsonProperty("productoId") Integer productoId) {

        this.productoId = productoId;
        this.cantidad = cantidad;

    }

    public Compra() {

    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    public Producto getProducto() {
        return producto;
    }

    public int getcantidad() {
        return cantidad;
    }

    public double total(){
        return (producto.getPrecio() * cantidad);
    }

    public void cargarProducto(ProductoService productoService) {
        producto = productoService.getProducto(productoId).getBody();
    }
}