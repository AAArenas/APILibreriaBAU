package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    public List<Cliente> getAllByStore(){
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sf = hu.getSessionFactory("select");
        Session session = sf.openSession();
        Query query = session.createSQLQuery("CALL kiosko.getAllClientes()").addEntity(Cliente.class);
        return query.list();
    }

    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
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