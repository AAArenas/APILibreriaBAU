package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Entity
@Table(name="Productos")
public class Producto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;
    @Column(name= "precio", nullable = false)
    private double precio;


    public Producto(){};

    public Producto(@JsonProperty("nombre") String nombre,
                    @JsonProperty("tipo") Integer tipo,
                    @JsonProperty("precio") double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = TipoProducto.values()[tipo-1].toString();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

