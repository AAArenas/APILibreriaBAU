package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name= "Factura")
public class Factura {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

   // @Column(name = "Fecha", nullable = false)
    //public LocalDate fecha = LocalDate.now();

    //public ArrayList<Compra> compras = new ArrayList<Compra>();

    @Column(name = "montoTotal", nullable = false)
    public Double montoTotal;


    public Factura(){

    }
    public Factura(@JsonProperty("montoTotal") Double montoTotal){

        this.montoTotal = montoTotal;
    }

    /*
    public Factura(LocalDate fecha, ArrayList<Compra> compras, Double montoTotal, Integer id) {
        this.id = id;
        this.fecha = fecha;
        this.compras = compras;
        this.montoTotal = montoTotal;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public LocalDate getFecha() {
        return fecha;
    }


     */
}
