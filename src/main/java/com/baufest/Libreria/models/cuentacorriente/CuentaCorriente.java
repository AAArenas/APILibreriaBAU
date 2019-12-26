package com.baufest.Libreria.models.cuentacorriente;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.Factura;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "cuentascorrientes")
public class CuentaCorriente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuentaCorriente")
    private List<Factura> facturas = new ArrayList<Factura>();

    public CuentaCorriente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Factura> getFactura() {
        return facturas;
    }

    public void setFactura(Set<Factura> factura) {
        this.facturas = facturas;
    }

    public void addFactura (Factura f){
        facturas.add(f);
    }
}
