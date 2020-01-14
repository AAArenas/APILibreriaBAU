package com.baufest.Libreria.service;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.baufest.Libreria.session.HibernateUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Service
public class DescuentoService {



    @Autowired
    DescuentoRepository descuentoRepository;

    //todo: hacer crud

    public ResponseEntity<Descuento> saveOrUpdateDescuento(Descuento descuento){

        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory(0).openSession()){
            System.out.println("session " + session);

            // start a transaction
            transaction = session.beginTransaction();
            //System.out.println("transaction " + transaction);

            // save the descuento object
            session.saveOrUpdate(descuento);
            System.out.println("-----------OK---------------");
            //commit transaction
            transaction.commit();
            return ResponseEntity.ok(descuento);
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


        //return ResponseEntity.ok(descuentoRepository.save(descuento));
    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public ResponseEntity<List<Descuento>> obtenerDescuentos() {
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory(0).openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            List<Descuento> descuentos= loadAllData(Descuento.class, session);
            System.out.println("-----------OK---------------");
            transaction.commit();
            return ResponseEntity.ok(descuentos);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    public ResponseEntity<Descuento> getDescuentoById(Integer id) {
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory(0).openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            Descuento descuento = (Descuento) session.get(Descuento.class,id);
            System.out.println("-----------OK---------------");
            transaction.commit();
            return ResponseEntity.ok(descuento);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    public  ResponseEntity<Descuento> delete(Integer descuentoId) {

        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory(0).openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            Descuento descuento = (Descuento) session.get(Descuento.class,descuentoId);
            session.delete(descuento);
            System.out.println("-----------OK---------------");
            transaction.commit();
            return ResponseEntity.ok(descuento);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }

    }

    public ResponseEntity<Descuento> update(Integer id, Descuento descuento){
        if (descuentoRepository.existsById(id)) {
            descuento.setId(id);
            System.out.println(descuento.getId());
            return this.saveOrUpdateDescuento(descuento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


/*
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
    }*/
}
