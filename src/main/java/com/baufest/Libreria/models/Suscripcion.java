package com.baufest.Libreria.models;

import com.baufest.Libreria.service.ProductoService;
import com.baufest.Libreria.service.cliente.ClienteService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.time.LocalDate;
import java.util.Calendar;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
@Table(name = "Suscripcion")
public class Suscripcion {

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

    @ManyToOne
    @JoinColumn(name = "cliente",nullable = false)
    private Cliente cliente;

    @Transient
    Integer clienteId;

    @Transient
    Integer productoId;

    public Suscripcion(@JsonProperty("cantidadMensual") Integer cantidadMensual,
                       @JsonProperty("finSuscripcion") LocalDate finSuscripcion,
                       @JsonProperty("clienteId") Integer clienteId,
                       @JsonProperty("productoId") Integer productoId){

        this.cantidadMensual = cantidadMensual;
        this.finSuscripcion = finSuscripcion;
        this.clienteId = clienteId;
        this.productoId = productoId;
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

    public Integer getCantidadSemanal() {
        return cantidadMensual;
    }

   /* public Integer getClienteId() {
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
        this.cliente = clienteService.obtenerClienteId(this.clienteId).get();
    }

    public void cargarProducto(ProductoService productoService) {
        this.producto = productoService.getProducto(this.productoId).getBody();
    }

}