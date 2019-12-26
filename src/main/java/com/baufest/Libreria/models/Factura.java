package com.baufest.Libreria.models;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name= "Factura")
public class Factura {

    //todo: recordar sacar los publics y agregar los getters

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "factura")
    private List<Compra> compras = new ArrayList<Compra>();

    @ManyToOne
    @JoinColumn(name = "cuentaCorriente")
    private CuentaCorriente cuentaCorriente;

    @Column(name = "montoTotal", nullable = false)
    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    public Factura(){

    }
    public Factura(@JsonProperty("montoTotal") Double montoTotal,
                   @JsonProperty("fecha") LocalDate fecha){

        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
