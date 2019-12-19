package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Compra;
import com.baufest.Libreria.models.Factura;
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
    /*
    @Autowired
    ProductoService productoService;

    ArrayList<Producto> productos = new ArrayList<Producto>();
    */

    public ResponseEntity<Factura> getFactura(Integer id){
        return ResponseEntity.ok(facturaRepository.findById(id).get());
    }

    public ResponseEntity<List<Factura>> getAllFactura(){
        return ResponseEntity.ok(facturaRepository.findAll());
    }

    public ResponseEntity<Factura> updateFactura(Integer id, Factura factura){
        Factura facturaUpdateable = getFactura(id).getBody();

        facturaUpdateable.fecha = factura.fecha;
        facturaUpdateable.montoTotal = factura.montoTotal;
        facturaUpdateable.compras = factura.compras;

        return saveFactura(facturaUpdateable);
    }

    public ResponseEntity<Factura> saveFactura(Factura factura){
        return ResponseEntity.ok(
                facturaRepository.save(factura)
        );
    }

    public ResponseEntity<?> deleteFactura (Integer id){
        facturaRepository.deleteById(id);
        return ResponseEntity.ok(1);
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
