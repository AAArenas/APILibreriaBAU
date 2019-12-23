package com.baufest.Libreria.models;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name= "Factura")
public class Factura {

    //todo: recordar sacar los publics y agregar los getters

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "Fecha", nullable = false)
    public LocalDate fecha;

    //public ArrayList<Compra> compras = new ArrayList<Compra>();

    @ManyToOne
    @JoinColumn(name = "cuentaCorriente")
    private CuentaCorriente cuentaCorriente;

    @Column(name = "montoTotal", nullable = false)
    public Double montoTotal;
/*
    Cliente cliente;
    Producto producto;
*/
    public Factura(){

    }
    public Factura(@JsonProperty("montoTotal") Double montoTotal,
                   @JsonProperty("fecha") LocalDate fecha){

        this.fecha = fecha;
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
