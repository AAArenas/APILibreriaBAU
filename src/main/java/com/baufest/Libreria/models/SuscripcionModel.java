package com.baufest.Libreria.models;

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
public class SuscripcionModel {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;

    @Column(name = "Inicio_de_suscripcion", nullable = true)
    protected LocalDate inicioSuscripcion;

    @Column(name = "Fin_de_suscripcion", nullable = true)
    LocalDate finSuscripcion;
    //@Column(name = "Producto", nullable = false)
    //Producto producto;

    @Column(name = "Cantidad_mensual")
    Integer cantidadMensual;


    public SuscripcionModel(/*Producto producto, */@JsonProperty("cantidadMensual") Integer cantidadMensual, @JsonProperty("finSuscripcion") LocalDate finSuscripcion){
     //   this.producto = producto;

        this.cantidadMensual = cantidadMensual;
        this.inicioSuscripcion = LocalDate.now();
        this.finSuscripcion = finSuscripcion;
    }

    public SuscripcionModel(){}

    public Integer getId() { return Id;}

    public void setId(Integer id) {
        Id = id;
    }

//    public Producto getProducto() {
  //      return producto;
    //}

    public LocalDate getInicio() {
        return inicioSuscripcion;
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


}