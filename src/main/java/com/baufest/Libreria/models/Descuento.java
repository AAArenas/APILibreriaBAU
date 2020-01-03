package com.baufest.Libreria.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Descuento")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true)
    private Integer id;

    @ManyToMany(mappedBy = "descuentos")
    private List<Factura> facturas = new ArrayList<>();

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valorDescuento")
    private double valorDescuento;

    public Descuento(@JsonProperty("valorDescuento") double valorDescuento, @JsonProperty("descripcion") String descripcion){
        this.descripcion = descripcion;
        this.valorDescuento = valorDescuento;
    }

    public Descuento(){}

    public double aplicarDescuento(double monto){
        return (monto - monto*valorDescuento);
    }

    public Integer getId(){
        return this.id;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }
}
