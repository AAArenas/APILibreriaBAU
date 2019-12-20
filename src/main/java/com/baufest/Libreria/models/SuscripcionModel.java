package com.baufest.Libreria.models;

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;
    @Column(name = "Inicio de suscripcion", nullable = false)
    protected LocalDate inicioSuscripcion;
    @Column(name = "Fin de suscripcion", nullable = false)
    protected LocalDate finSuscripcion;
   // @Column(name = "Producto", nullable = false)
   // protected Producto producto;
    @Column(name = "Cantidad mensual")
    protected Integer cantidadMensual;


    public SuscripcionModel(/*Producto producto, */Integer cantidadMensual, LocalDate finSuscripcion){
       // this.producto = producto;
        this.cantidadMensual = cantidadMensual;
        this.inicioSuscripcion = LocalDate.now();
        this.finSuscripcion = finSuscripcion;
    }

    public Integer getId() { return Id;}

    public void setId(Integer id) {
        Id = id;
    }
/*
    public Producto getProducto() {
        return producto;
    }
*/
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