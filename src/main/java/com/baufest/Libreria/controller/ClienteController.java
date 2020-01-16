package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.ClienteModel;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/cliente")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@NonNull @RequestBody ClienteModel clienteModel) {
        Cliente cliente = new Cliente(clienteModel);
        return clienteService.save(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        return clienteService.getAll();
    }

    @GetMapping(path="/store")
    public List<Cliente> getStore(){
        return clienteService.getAllByStore();
    }


    @GetMapping(path="/{id}")
    public ResponseEntity<Cliente> obtenerClienteId(@PathVariable("id") Integer id) {
        return clienteService.getById(id);
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<Cliente> borrarClienteId(@PathVariable("id") Integer id) {
        return clienteService.delete(id);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Cliente> editarcliente(@PathVariable("id") Integer id, @NonNull @RequestBody Cliente cliente) {
        return clienteService.update(cliente,id);
    }

    /*@GetMapping(path = "/{id}/suscripciones")
    public ResponseEntity<List<Suscripcion>> listarSuscripcionesByClienteId(@PathVariable ("id") Integer id){
        System.out.println("--ok--");
        return clienteService.listarSuscripcionesByClienteId(id);
    }*/
}
