package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import com.baufest.Libreria.service.ClienteService;
import com.baufest.Libreria.service.ProductoService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Suscripcion")
public class Suscripcion implements IClave {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;

    @Column(name = "Inicio_de_suscripcion", nullable = true)
    protected LocalDate inicioSuscripcion;

    @Column(name = "Fin_de_suscripcion", nullable = true)
    LocalDate finSuscripcion;

    @ManyToOne
    @JoinColumn(name = "Producto", nullable = false)
    Producto producto;

    @Column(name = "Cantidad_mensual")
    Integer cantidadMensual;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente",nullable = false)
    private Cliente cliente;

    @Column(name = "anual")
    private boolean anual;

    @Column(name="direccionDeEntrega")
    private String direccionDeEntrega;

    @Transient
    Integer clienteId;

    @Transient
    Integer productoId;

    public Suscripcion(@JsonProperty("cantidadMensual") Integer cantidadMensual,
                       @JsonProperty("finSuscripcion") LocalDate finSuscripcion,
                       @JsonProperty("clienteId") Integer clienteId,
                       @JsonProperty("productoId") Integer productoId,
                       @JsonProperty("anual") boolean anual){

        this.cantidadMensual = cantidadMensual;
        this.finSuscripcion = finSuscripcion;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.anual = anual;
    }

    public Suscripcion(){}

    public Integer getId() { return Id;}

    public void setId(Integer id) {
        Id = id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public LocalDate getInicio() {
        return inicioSuscripcion;
    }

    public void setInicioSuscripcion(LocalDate inicioSuscripcion){
        this.inicioSuscripcion = inicioSuscripcion;
    }

    public void comenzarSuscripcion(){
        this.inicioSuscripcion = LocalDate.now();
    }

    public LocalDate getFin() {
        return finSuscripcion;
    }

    public void setFinSuscripcion(LocalDate finSuscripcion){
        this.finSuscripcion = finSuscripcion;
    }

    public void setCantidadMensual(Integer cantidadMensual){
        this.cantidadMensual = cantidadMensual;
    }

    public Integer getCantidadMensual() {
        return cantidadMensual;
    }

/*
    public Integer getClienteId() {
        return this.clienteId;
    }

    public Integer getProductoId() {
        return this.productoId;
    }
*/

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void cargarCliente(ClienteService clienteService) {
        this.cliente = clienteService.obtenerClienteId(this.clienteId).getBody();
        this.direccionDeEntrega = this.cliente.getDireccion();
    }

    public void cargarProducto(ProductoService productoService) {
        this.producto = productoService.getProducto(this.productoId).getBody();
    }

    public boolean getAnual(){
        return anual;
    }

    public String getDireccionDeEntrega() {
        return direccionDeEntrega;
    }

    public void setDireccionDeEntrega(String direccionDeEntrega) {
        this.direccionDeEntrega = direccionDeEntrega;
    }
}