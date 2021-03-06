package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente implements IClave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true)
    private Integer id;

    @Column(name="name")
    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Suscripcion> suscripciones;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;



    @Autowired
    public Cliente(Integer id, String direccion, String nombre) {
        this.id = id;
        this.direccion = direccion;
        this.name = nombre;
    }

    @Autowired
    public Cliente(){

    }

    public Cliente (ClienteModel clienteModel){
      //  this.id = clienteModel.getId();
        this.direccion = clienteModel.getDireccion();
        this.name = clienteModel.getName();
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
