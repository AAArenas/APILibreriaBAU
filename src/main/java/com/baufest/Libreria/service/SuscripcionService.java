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

    @Autowired
    SuscripcionRepository suscripcionRepository;


    public ResponseEntity<Suscripcion> save(Suscripcion suscripcion){
        return suscripcionRepository.save(suscripcion);
    }

    public ResponseEntity<Suscripcion> getById(Integer id){
        return suscripcionRepository.getById(Suscripcion.class,id);
    }

    public ResponseEntity<List<Suscripcion>> getAll(){

        return suscripcionRepository.getAll(Suscripcion.class);
    }

    public ResponseEntity<Suscripcion> delete(Integer id){
        return suscripcionRepository.delete(Suscripcion.class,id);
    }

    public ResponseEntity<Suscripcion> update(Integer Id, Suscripcion suscripcion) {
        //if (suscripcion.get) Fixme: validar... que validar?
        if (suscripcionRepository.existById(Suscripcion.class,Id)) {
            Suscripcion suscripcionAux  = this.getById(Id).getBody();
            suscripcion.setInicioSuscripcion(suscripcionAux.getInicio());
            suscripcion.cargarCliente(clienteService);
            suscripcion.cargarProducto(productoService);
            suscripcion.setId(Id);
            return suscripcionRepository.update(suscripcion,Id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Factura> generarFactura(Integer id) {
        Suscripcion suscripcion = (Suscripcion) suscripcionRepository.getById(Suscripcion.class,id).getBody();
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
       return (ResponseEntity<List<Suscripcion>>) suscripcionRepository.findByClienteId(id).get();
    }
}