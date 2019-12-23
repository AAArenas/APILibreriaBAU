package com.baufest.Libreria.models;

import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Compra {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //Integer id_factura;
    Factura factura;

    //Integer id_renglon

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @OneToOne
    @JoinColumn(name="producto")
    private Producto _producto;


    public Compra() {

    }


}
