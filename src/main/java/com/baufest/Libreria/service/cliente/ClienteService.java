package com.baufest.Libreria.service.cliente;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private static List<Cliente> DB=new ArrayList<>();
    @Autowired
    ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        DB=clienteRepository.findAll();
        return DB;
    }

    public Optional<Cliente> obtenerClienteId(Integer id) {
        return clienteRepository.findById(id);
    }

    public int borrarClienteId(Integer id)
    {
        Optional<Cliente> cliente=obtenerClienteId(id);
        if(cliente.isEmpty()) {
            return 0;
        } else {
            clienteRepository.delete(cliente.get());
            return 1;
        }
    }

    public String editarCliente(Integer id, Cliente cliente) {
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
    }
}