package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import com.baufest.Libreria.service.ProductoService;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Compra implements IClave {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name="factura")
    Factura factura;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @ManyToOne
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
    public void setId(Integer Id){

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

    public void setProducto(Producto producto){
        this.producto = producto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setProductoId(Integer id) {
        this.productoId = id;
    }
}