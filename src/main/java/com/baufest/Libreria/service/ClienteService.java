package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SuscripcionService suscripcionService;

    @Autowired
    SuscripcionRepository suscripcionRepository;


    public ResponseEntity crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.getAll(Cliente.class).getBody();
    }

    public ResponseEntity<Cliente> obtenerClienteId(Integer id) {
        return clienteRepository.getById(Cliente.class,id);
    }

    public ResponseEntity<Cliente> borrarClienteId(Integer id)
    {
        ResponseEntity<Cliente> cliente=obtenerClienteId(id);
        return clienteRepository.delete(Cliente.class,id);
    }

    public ResponseEntity<Cliente> editarCliente(Integer id, Cliente cliente) {
        return clienteRepository.update(cliente,id);
    }

    public ResponseEntity<List<Suscripcion>> listarSuscripcionesByClienteId(Integer id) {
        return suscripcionService.listarSuscripcionesByClienteId(id);
    }



    /*public ResponseEntity<Cliente> editarCliente(Integer id, Cliente cliente) {
        if(cliente.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            if(clienteRepository.existsById(id)) {
                cliente.setId(id);
                return ResponseEntity.ok(clienteRepository.save(cliente));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
    }*/

}