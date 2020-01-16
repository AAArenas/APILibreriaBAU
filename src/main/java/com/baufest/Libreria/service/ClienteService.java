package com.baufest.Libreria.service;
import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
<<<<<<< HEAD
import com.baufest.Libreria.repository.DescuentoRepository;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
=======
import com.baufest.Libreria.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
>>>>>>> 116fa75170b67f856f155995fe9ceb063be07958
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

<<<<<<< HEAD
    public ResponseEntity<Cliente> save(Cliente cliente){
=======

    public List<Cliente> getAllByStore(){
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sf = hu.getSessionFactory("select");
        Session session = sf.openSession();
        Query query = session.createSQLQuery("CALL kiosko.getAllClientes()").addEntity(Cliente.class);
        return query.list();
    }

    public Cliente crearCliente(Cliente cliente){
>>>>>>> 116fa75170b67f856f155995fe9ceb063be07958
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<Cliente> getById(Integer id){
        return clienteRepository.getById(Cliente.class,id);
    }

    public ResponseEntity<List<Cliente>> getAll(){

        return clienteRepository.getAll(Cliente.class);
    }

<<<<<<< HEAD
    public ResponseEntity<Cliente> delete(Integer id){
        return clienteRepository.delete(Cliente.class,id);
    }

    public ResponseEntity<Cliente> update(Cliente cliente,Integer id){
        return clienteRepository.update(cliente,id);
=======
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
>>>>>>> 116fa75170b67f856f155995fe9ceb063be07958
    }
}