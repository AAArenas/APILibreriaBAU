package com.baufest.Libreria.models.cuentacorriente;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
@Entity
@Table (name = "cuentas")
public class CuentaCorriente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false, length = 30)
    @NotBlank
    private String name;

    //private ArrayList <Factura> facturas = new ArrayList<>();

    public CuentaCorriente(@JsonProperty("name") String name) {
        this.name = name;
    }

    public CuentaCorriente() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
