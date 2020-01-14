package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.repository.SuscripcionRepository;
import com.baufest.Libreria.session.HibernateUtil;
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

    public ResponseEntity<Cliente> crearOActualizarCliente(Cliente cliente){

        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try ( Session session = hu.getSessionFactory("insert").openSession()){

            // start a transaction
            transaction = session.beginTransaction();

            // save the descuento object
            session.saveOrUpdate(cliente);

            //commit transaction
            transaction.commit();
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        } /*finally {
            session.close();
        }*/
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

    public ResponseEntity<Cliente> editarCliente(Integer id, Cliente cliente) {

        if(clienteRepository.existsById(id)) {
            Transaction transaction = null;
            HibernateUtil hu = new HibernateUtil();
            Session session = hu.getSessionFactory("insert").openSession();
            try {
                System.out.println("session " + session);

                // start a transaction
                transaction = session.beginTransaction();
                //System.out.println("transaction " + transaction);

                // save the descuento object
                cliente.setId(id);
                session.saveOrUpdate(cliente);
                System.out.println("-----------OK---------------");

                if ( cliente.getDireccion() != this.obtenerClienteId(id).get().getDireccion()){
                    List<Suscripcion> suscripciones = suscripcionRepository.findByClienteId(id).get();
                    int cantSuscripciones = suscripciones.size();
                    for ( int i = 0; i < cantSuscripciones; i++) {
                        suscripciones.get(i).setDireccionDeEntrega(cliente.getDireccion());
                        session.saveOrUpdate(suscripciones.get(i));
                    }
                }

                //commit transaction
                transaction.commit();

            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();

            } finally {
                session.close();
            }
        }
        return ResponseEntity.ok(cliente);
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