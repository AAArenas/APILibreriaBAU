package com.baufest.Libreria.repository;
import com.baufest.Libreria.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCustom<S extends IClave > {

    /* ================================================================================
    *
    *   ALL METHODS HERE
    *
    * ================================================================================*/
    default Boolean existById(Class<S> type, Integer id) {
        if(this.getById(type,id).getBody() == type) {
            return true;
        } else {
            return false;
        }
    }
    default ResponseEntity save(S var1) {
        System.out.println("-----------SAVE---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory("insert").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();

            session.save(var1);
            transaction.commit();
            System.out.println("-----------OK---------------");
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

    default ResponseEntity getById(Class<S> type, Integer id) {
        System.out.println("-----------GET BY ID---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory("select").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            S var= (S) session.get(type,id);
            transaction.commit();
            System.out.println("-----------OK---------------");
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

    private static <S> List<S> loadAllData(Class<S> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<S> criteria = builder.createQuery(type);
        criteria.from(type);
        List<S> data = session.createQuery(criteria).getResultList();
        return data;
    }

    default ResponseEntity<List<S>> getAll(Class<S> type) {
        System.out.println("-----------GET ALL---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory("select").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            List<S> list= loadAllData(type, session);
            transaction.commit();
            System.out.println("-----------OK---------------");
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

    default ResponseEntity<S> delete(Class<S> type,Integer id) {
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory("delete").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            S var = (S) session.get(type,id);
            session.delete(var);
            System.out.println("-----------OK---------------");
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

    default ResponseEntity<S> update(S var1,Integer Id) {
        var1.setId(Id);
        System.out.println("-----------SAVE---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory("insert").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();

            session.update(var1);
            transaction.commit();
            System.out.println("-----------OK---------------");
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
