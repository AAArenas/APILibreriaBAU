package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.service.ClienteService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/cliente")

@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @PostMapping
    public Cliente crearCliente(@NonNull @RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }
    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }
    @GetMapping(path="/{id}")
    public Cliente obtenerClienteId(@PathVariable("id") Integer id) {
        return clienteService.obtenerClienteId(id).get();
    }
    @DeleteMapping(path="{id}")
    public int borrarClienteId(@PathVariable("id") Integer id) {
        return clienteService.borrarClienteId(id);
    }
    @PostMapping(path="/{id}")
    public String editarcliente(@PathVariable("id") Integer id,@NonNull @RequestBody Cliente cliente) {
        return clienteService.editarCliente(id,cliente);
    }
}
