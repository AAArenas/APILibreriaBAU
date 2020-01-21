package com.baufest.Libreria.models;

import com.baufest.Libreria.repository.IClave;
import com.baufest.Libreria.service.ClienteService;
//import com.baufest.Libreria.service.CuentaCorrienteService;
import com.baufest.Libreria.service.DescuentoService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Factura")
public class Factura implements IClave {

    //todo: recordar sacar los publics y agregar los getters

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "factura",  fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Compra> compras = new ArrayList<Compra>();

//    @ManyToOne
//    @JoinColumn(name = "cuentaCorriente")
//    private CuentaCorriente cuentaCorriente;

    @Column(name = "montoTotal", nullable = false)
    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "factura_descuento",
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Descuento> descuentos = new ArrayList<>();

    @Transient
    Integer clienteId;

    @Transient
    List<Integer> descuentosId;

    @Column(name = "pagada", nullable = false)
    private boolean pagado = false;

    public Factura() {
    }

    public Factura(@JsonProperty("compras") List<Compra> compras, @JsonProperty("descuentosId") List<Integer> descuentosId, @JsonProperty("clienteId") Integer clienteId, @JsonProperty("pagado") boolean pagado) {
        this.descuentosId = descuentosId;
        this.fecha = LocalDate.now();
        this.compras = compras;
        this.clienteId = clienteId;
        this.pagado = pagado;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

//    public CuentaCorriente getCuentaCorriente() {
//        return cuentaCorriente;
//    }

//    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
//        this.cuentaCorriente = cuentaCorriente;
//    }

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

//    public void cargarCuentaCorriente(CuentaCorrienteService cuentaCorrienteService) {
//        this.cuentaCorriente = cuentaCorrienteService.getCuentaCorrienteByClienteId(this.clienteId).get();
//    }

    public void cargarCliente(ClienteService clienteService) {
        this.cliente = clienteService.obtenerClienteId(this.clienteId).getBody();
    }

    public void cargarDescuentos(DescuentoService descuentoService){
        Integer cantDescuentos = this.descuentosId.size();
        for (int i = 0 ; i<cantDescuentos; i++){
            this.descuentos.add(descuentoService.getById(descuentosId.get(i)).getBody());
        }
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

    public boolean getPagado(){
        return pagado;
    }

    public List<Descuento> getDescuentos(){
        return descuentos;
    }

    public void setId(Integer Id) {

    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void setClienteId(Integer id) {
        this.clienteId = id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

}