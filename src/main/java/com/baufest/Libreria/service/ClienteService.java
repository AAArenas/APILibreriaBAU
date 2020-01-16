package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.repository.SuscripcionRepository;
import com.baufest.Libreria.session.HibernateUtil;
import org.apache.coyote.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
  /*  public String editarCliente(Integer id, Cliente cliente) {
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