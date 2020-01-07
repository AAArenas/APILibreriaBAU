package com.baufest.Libreria.service;

import com.baufest.Libreria.models.*;
import com.baufest.Libreria.repository.CompraRepository;
import com.baufest.Libreria.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    CompraRepository compraRepository;

//  @Autowired
//  CuentaCorrienteService cuentaCorrienteService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    DescuentoService descuentoService;

    @Autowired
    ProductoService productoService;


    /*
    @Autowired
    ProductoService productoService;

    ArrayList<Producto> productos = new ArrayList<Producto>();
    */

    public ResponseEntity<Factura> getFactura(Integer id) {
        return ResponseEntity.ok(facturaRepository.findById(id).get());
    }

    public ResponseEntity<List<Factura>> getAllFactura() {
        return ResponseEntity.ok(facturaRepository.findAll());
    }

    public ResponseEntity<Factura> updateFactura(Integer id, Factura factura) {
        Factura facturaUpdateable = getFactura(id).getBody();

        facturaUpdateable.setDescuentos(factura.getDescuentos());
  //    facturaUpdateable.setFecha(factura.getFecha());
        this.calcularMontoTotal(facturaUpdateable);
  //    facturaUpdateable.setCompras(factura.getCompras());

        return saveFactura(facturaUpdateable);
    }

    public ResponseEntity<Factura> saveFactura(Factura facturaVirtual) {

        facturaVirtual.cargarCliente(clienteService);
//      facturaVirtual.cargarCuentaCorriente(cuentaCorrienteService);
        facturaVirtual.cargarDescuentos(descuentoService);
        List<Compra> compras = facturaVirtual.getCompras();
        for (int i = 0; i < compras.size(); i++) {
            compras.get(i).cargarProducto(productoService);
        }
        this.calcularMontoTotal(facturaVirtual);
        Factura factura = facturaRepository.save(facturaVirtual);
        for (int i = 0; i < compras.size(); i++) {
            compras.get(i).cargarProducto(productoService);
            compras.get(i).setFactura(factura);
            compraRepository.save((compras.get(i)));
        }

        return ResponseEntity.ok(
                facturaRepository.save(factura)
        );
    }

    public ResponseEntity<?> deleteFactura(Integer id) {
        facturaRepository.deleteById(id);
        return ResponseEntity.ok(1);
    }

    public ResponseEntity<Factura> calcularMontoTotal(Factura factura) {

        double montoTotal = 0;
        List<Compra> compras = factura.getCompras();
        int cantCompras = compras.size();

        for (int i = 0; i < cantCompras; i++) {
            montoTotal += compras.get(i).total();
        }
        factura.setMontoTotal(montoTotal);
        factura.aplicarDescuentos();
        return ResponseEntity.ok(factura);
    }

    private void aplicarDescuentos(Factura factura) {
        factura.aplicarDescuentos();
    }

    public ResponseEntity<Factura> pagarFactura(Integer id) {
        Factura factura = this.getFactura(id).getBody();
        factura.pagar();
        return (ResponseEntity.ok(facturaRepository.save(factura)));
    }


    /*
    public ResponseEntity<ArrayList<Producto>> MostrarFactura(){

        productos = productoService.findAll();
        return ResponseEntity.ok(ArrayList<Producto>);

        // Devuelve la lista de producto
        for (Compra p : compras){
            System.out.println(p.getProducto());
            System.out.println(p.devolverPrecio());
        }
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void calcularTotal() {
        for (Compra p : compras){
            this.montoTotal += p.devolverPrecio();
        }

        if (this.clienteAntiguo){
            Descuento MiDescuento = new Descuento();
            this.montoTotal = MiDescuento.aplicardescuento(this);
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarCompra (Compra MiCompra){
        this.compras.add(MiCompra);
    }

    public Factura cerrarFactura (){
        return this;
    }
    */

}
