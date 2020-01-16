package com.baufest.Libreria.service;
import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.repository.DescuentoRepository;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<Cliente> save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<Cliente> getById(Integer id){
        return clienteRepository.getById(Cliente.class,id);
    }

    public ResponseEntity<List<Cliente>> getAll(){

        return clienteRepository.getAll(Cliente.class);
    }

    public ResponseEntity<Cliente> delete(Integer id){
        return clienteRepository.delete(Cliente.class,id);
    }

    public ResponseEntity<Cliente> update(Cliente cliente,Integer id){
        return clienteRepository.update(cliente,id);
    }
}