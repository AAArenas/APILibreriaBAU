package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Compra;
import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Factura;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;
    @Autowired
    SuscripcionRepository suscripcionRepository;

    public ResponseEntity<List<Suscripcion>> getAllSuscripcions() {
        List<Suscripcion> suscripciones = suscripcionRepository.findAll();
        return ResponseEntity.ok(suscripciones);
    }

    public ResponseEntity<Suscripcion> getSuscripcionById(Integer suscripcionId) {
        Optional<Suscripcion> optionalSuscripcionModel = suscripcionRepository.findById(suscripcionId);
        if (optionalSuscripcionModel.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optionalSuscripcionModel.get());
    }

    public ResponseEntity<Suscripcion> save(Suscripcion suscripcion) {
        suscripcion.cargarCliente(clienteService);
        suscripcion.cargarProducto(productoService);
        suscripcion.comenzarSuscripcion();
        Suscripcion nuevaSuscripcion = suscripcionRepository.save(suscripcion);
        return ResponseEntity.ok(nuevaSuscripcion);
    }

    public  ResponseEntity<Integer> delete(Integer suscripcionId) {
        try {
            suscripcionRepository.deleteById(suscripcionId);
            return ResponseEntity.ok(suscripcionId);
        } catch (EmptyResultDataAccessException exc) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }

    public ResponseEntity<Suscripcion> update(Integer Id, Suscripcion suscripcion) {
        //if (suscripcion.get) Fixme: validar... que validar?
        if (suscripcionRepository.existsById(Id)) {
            Suscripcion suscripcionAux  = this.getSuscripcionById(Id).getBody();
            suscripcion.setInicioSuscripcion(suscripcionAux.getInicio());
            suscripcion.cargarCliente(clienteService);
            suscripcion.cargarProducto(productoService);
            suscripcion.setId(Id);
            return ResponseEntity.ok(suscripcionRepository.save(suscripcion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Factura> generarFactura(Integer id) {

        Suscripcion suscripcion = this.getSuscripcionById(id).getBody();
        Compra compra = new Compra();
        Factura factura = new Factura();
        List<Compra> compras = new ArrayList<>();

        compra.setProductoId(suscripcion.getProducto().getId());
        compra.setCantidad(suscripcion.getCantidadMensual());
        compras.add(compra);

        factura.setCompras(compras);
        factura.setClienteId(suscripcion.getCliente().getId());

        return ResponseEntity.ok(factura);
    }

}