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

    /*
    @PostMapping
    public Cliente crearCliente(@NonNull @RequestBody ClienteModel clienteModel){
        Cliente cliente = new Cliente(clienteModel);
        return clienteService.crearCliente(cliente);
    }*/

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@NonNull @RequestBody ClienteModel clienteModel) {
        Cliente cliente = new Cliente(clienteModel);
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @GetMapping(path="/{id}")
    public Cliente obtenerClienteId(@PathVariable("id") Integer id) {
        return clienteService.obtenerClienteId(id).getBody();
    }

    @DeleteMapping(path="{id}")
    public Cliente borrarClienteId(@PathVariable("id") Integer id) {
        return clienteService.borrarClienteId(id).getBody();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Cliente> editarcliente(@PathVariable("id") Integer id, @NonNull @RequestBody Cliente cliente) {
        return clienteService.editarCliente(id,cliente);
    }

    @GetMapping(path = "/{id}/suscripciones")
    public ResponseEntity<List<Suscripcion>> listarSuscripcionesByClienteId(@PathVariable ("id") Integer id){
        System.out.println("--ok--");
        return clienteService.listarSuscripcionesByClienteId(id);
    }

}
