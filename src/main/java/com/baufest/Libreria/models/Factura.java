package com.baufest.Libreria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Factura {

    private Integer id;
    private LocalDate fecha;
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private Double montoTotal;

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
}
