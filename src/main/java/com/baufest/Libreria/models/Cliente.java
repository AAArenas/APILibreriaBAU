package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;

//@Entity
//@Table(name="clientes")
public class Cliente {
    //CuentaCorriente cuenta;
    //HashMap<String, Suscripcion> suscripciones = new HashMap<String, Suscripcion>();

    public Cliente(/*@JsonProperty("id")*/ int id, /*@JsonProperty("name")*/ String name,/*@JsonProperty("direccion")*/ String direccion){
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        //this.cuenta
        //this.suscripciones
    }
    //@Id
    //@Column(name="id")
    private int id;
    //@Column(name="name")
    //@NotBlank
    private String name;
    //@Column(name="direccion")
    //@NotBlank
    private String direccion;
    //@OneToMany(mappedBy="cliente")
    //@Column(name="suscripciones")
    //private Hashmap<String, Suscripcion> suscripciones;
    // @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, nullable = false, updatable = false)
    // private Cuenta cuenta;

    public int getId(){
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDireccion() {
        return this.direccion;
    }
}
