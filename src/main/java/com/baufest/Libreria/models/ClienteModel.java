package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class ClienteModel implements IClave {


    private Integer id;


    private String name;


    private String direccion;

    private List<Suscripcion> suscripciones;

    private List<Factura> facturas;

//    @OneToOne(mappedBy = "cliente")
//    CuentaCorriente cuentaCorriente;

    @Autowired
    public ClienteModel(Integer id, String direccion, String nombre) {
        this.id = id;
        this.direccion = direccion;
        this.name = nombre;
    }

    @Autowired
    public ClienteModel(){

    }

    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
