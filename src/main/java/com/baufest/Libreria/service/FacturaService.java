package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Compra;
import com.baufest.Libreria.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ProductoService productoService;

    ArrayList<Producto> productos = new ArrayList<Producto>();

    public ResponseEntity<ArrayList<Producto>> MostrarFactura(){

        productos = productoService.findAll();
        return ResponseEntity.ok(ArrayList<Producto>);
        /*
        // Devuelve la lista de producto
        for (Compra p : compras){
            System.out.println(p.getProducto());
            System.out.println(p.devolverPrecio());
        }*/
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
}
