package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.session.SessionHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public abstract class CustomRepositoryImpl<T extends IClave,ID> implements RepositoryCustom<T ,Integer> {

    @Autowired
    SessionHandler sessionHandler;

    @Override
    public ResponseEntity save(IClave var1) {

        System.out.println("-----------SAVE---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            session.save(var1);
            transaction.commit();
            return ResponseEntity.ok(var1);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }


    @Override
    public ResponseEntity getById(Class type, Integer id) {

        System.out.println("-----------GET BY ID---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            T var= (T) session.get(type,id);
            transaction.commit();
            return ResponseEntity.ok(var);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }


    private <S> List<S> loadAllData(Class<S> type, Session session) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<S> criteria = builder.createQuery(type);
        criteria.from(type);
        List<S> data = session.createQuery(criteria).getResultList();
        return data;

    }


    @Override
    public ResponseEntity<List<T>> getAll(Class type) {

        System.out.println("-----------GET ALL---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            List<T> list= loadAllData(type, session);
            transaction.commit();
            return ResponseEntity.ok(list);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }


    public ResponseEntity<List<Suscripcion>> findByClienteId(@Param("clienteId") Integer clienteId) {

        System.out.println("-----------GET ALL---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            List<Suscripcion> suscripciones = session.createQuery("select s from Suscripcion s where s.cliente.id = :clienteId").list();
            transaction.commit();
            return ResponseEntity.ok(suscripciones);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }


    @Override
    public ResponseEntity delete(Class type, Integer id) {

        System.out.println("------------DELETE---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            T var = (T) session.get(type,id);
            session.delete(var);
            transaction.commit();
            return ResponseEntity.ok(var);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }


    @Override
    public ResponseEntity update(IClave var1, Integer Id) {

        var1.setId(Id);
        System.out.println("-------------UPDATE---------------");
        Transaction transaction = null;

        try (Session session = sessionHandler.getSession()){

            System.out.println("session " + session);
            transaction = session.beginTransaction();
            session.update(var1);
            transaction.commit();
            return ResponseEntity.ok(var1);

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

}
