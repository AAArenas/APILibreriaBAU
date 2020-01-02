package com.baufest.Libreria.models;

import com.baufest.Libreria.service.ClienteService;
import com.baufest.Libreria.service.CuentaCorrienteService;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Factura")
public class Factura {

    //todo: recordar sacar los publics y agregar los getters

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "factura")
    private List<Compra> compras = new ArrayList<Compra>();

    @ManyToOne
    @JoinColumn(name = "cuentaCorriente")
    private CuentaCorriente cuentaCorriente;

    @Column(name = "montoTotal", nullable = false)
    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "factura_descuento",
            joinColumns = {@JoinColumn(referencedColumnName = "factura_id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "descuento_id")})
    public List<Descuento> descuentos = new ArrayList<>();

    @Transient
    Integer clienteId;

    //@Transient
   // final static double DESCUENTO_CLIENTE_CONOCIDO = 0.05;

    @Column(name = "pagada", nullable = false)
    private boolean pagado = false;

    public Factura() {

    }

    public Factura(@JsonProperty("compras") List<Compra> compras) {

        this.fecha = LocalDate.now();
        this.compras = compras;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void cargarCuentaCorriente(CuentaCorrienteService cuentaCorrienteService) {
        this.cuentaCorriente = cuentaCorrienteService.getCuentaCorrienteByClienteId(this.clienteId).get();
    }

    public void cargarCliente(ClienteService clienteService) {
        this.cliente = clienteService.obtenerClienteId(this.clienteId).get();
    }

    public Integer getId() {
        return this.id;
    }

    public void aplicarDescuentos() {
        int cantDescuentos = descuentos.size();
        for (int i = 0 ; i < cantDescuentos; i++){
            montoTotal = descuentos.get(i).aplicarDescuento(montoTotal);
        }
    }

    public void pagar(){
        pagado = true;
    }

}
