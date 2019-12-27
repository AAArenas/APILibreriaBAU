package com.baufest.Libreria.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import java.time.LocalDate;

public class SuscripcionBE extends SuscripcionDB{

    @Transient
    Integer clienteId;

    @Transient
    Integer productoId;

    public SuscripcionBE(@JsonProperty("cantidadMensual") Integer cantidadMensual, @JsonProperty("finSuscripcion") LocalDate finSuscripcion,@JsonProperty("clienteId") Integer clienteId, @JsonProperty("productoId") Integer productoId){

        this.cantidadMensual = cantidadMensual;
        this.inicioSuscripcion = LocalDate.now();
        this.finSuscripcion = finSuscripcion;
        this.productoId = productoId;
        this.clienteId = clienteId;
    }

    public SuscripcionBE(){}

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public void setProducto(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getClienteId() {
        return this.clienteId;
    }

    public Integer getProductoId(){
        return this.productoId;
    }
}