package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Producto {


    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String tipo;
    @NotBlank
    private double precio;

    public Producto(@JsonProperty("name") String nombre,
                    @JsonProperty("tipo") String tipo,
                    @JsonProperty("precio") double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Long getId() {
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
}

