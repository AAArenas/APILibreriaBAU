package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;

@Entity
@Table(name="clientes")
public class Cliente {

    @Autowired

    @Id
    @GeneratedValue
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;
    @Column(name="name")
    @NotBlank
    private String name;
    @Column(name="direccion")
    @NotBlank
    private String direccion;

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
