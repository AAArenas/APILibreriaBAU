package com.baufest.Libreria.service;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentoService {

    @Autowired
    DescuentoRepository descuentoRepository;

    //todo: hacer crud

    public ResponseEntity<Descuento> crearDescuento(Descuento descuento){
        return ResponseEntity.ok(descuentoRepository.save(descuento));
    }

    public ResponseEntity<List<Descuento>> obtenerDescuentos() {
        return ResponseEntity.ok(descuentoRepository.findAll());
    }

    public ResponseEntity<Descuento> getDescuentoById(Integer id) {
        return ResponseEntity.ok(descuentoRepository.findById(id).get());
    }

    public  ResponseEntity<Integer> delete(Integer descuentoId) {
        try {
            descuentoRepository.deleteById(descuentoId);
            return ResponseEntity.ok(descuentoId);
        } catch (EmptyResultDataAccessException exc) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

/*    public String editarCliente(Integer id, Cliente cliente) {
        if(cliente.getId() != null) {
            return "El id no puede estar en el body";
        } else {
            if(clienteRepository.existsById(id)) {
                cliente.setId(id);
                clienteRepository.save(cliente);
                return "modificado";
            } else {
                return "El id no existe";
            }
        }
    }*/
}
