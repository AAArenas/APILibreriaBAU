package com.baufest.Libreria.models.cuentacorriente;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@Entity
@Table (name = "cuentas")
public class CuentaCorriente {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    public CuentaCorriente(@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public CuentaCorriente() {
    }

    /*
    @NotNull
    @OneToOne
    @JoinColumn(name = id)
    private Cliente cliente;


    private ArrayList <Factura> facturas = new ArrayList<>();
*/



    /*
    public CuentaCorriente(@NotNull Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

     */

}
