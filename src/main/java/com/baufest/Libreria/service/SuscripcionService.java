package com.baufest.Libreria.service;

import com.baufest.Libreria.models.*;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
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
    //@Autowired
    //JpaRepository<Suscripcion, Integer> repository;

    @Autowired
    SuscripcionRepository suscripcionRepository;


    public ResponseEntity<List<Suscripcion>> getAllSuscripcions() {
        return suscripcionRepository.getAll(Suscripcion.class);
    }

    public ResponseEntity<Suscripcion> getSuscripcionById(Integer suscripcionId) {
        return suscripcionRepository.getById(Suscripcion.class,suscripcionId);
    }

    public ResponseEntity<Suscripcion> save(Suscripcion suscripcion) {
       suscripcion.cargarCliente(clienteService);
       suscripcion.cargarProducto(productoService);
        return suscripcionRepository.save(suscripcion);
    }

    public  ResponseEntity<Suscripcion> delete(Integer suscripcionId) {
        return suscripcionRepository.delete(Suscripcion.class,suscripcionId);
    }

    public ResponseEntity<Suscripcion> update(Integer Id, Suscripcion suscripcion) {
        return suscripcionRepository.update(suscripcion,Id);
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

    public ResponseEntity<List<Suscripcion>> listarSuscripcionesByClienteId(Integer id) {
       return suscripcionRepository.findByClienteId(id);
    }
}