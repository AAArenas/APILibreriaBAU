package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "descuento")
public class Descuento implements Serializable, IClave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @ManyToMany(mappedBy = "descuentos")
    private List<Factura> facturas = new ArrayList<>();

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valor_descuento")
    private double valorDescuento;

    public Descuento(@JsonProperty("valorDescuento") double valorDescuento, @JsonProperty("descripcion") String descripcion){
        this.descripcion = descripcion;
        this.valorDescuento = valorDescuento;
    }

    public Descuento(){}

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento){
        this.valorDescuento = valorDescuento;
    }

    public double aplicarDescuento(double monto){
        return (monto - monto*valorDescuento);
    }

}