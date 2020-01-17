package com.baufest.Libreria.repository;

import com.baufest.Libreria.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@NoRepositoryBean
public interface RepositoryCustom<T extends IClave,ID> extends Repository<T, ID>, QueryByExampleExecutor<T>{

    /* ================================================================================
    *
    *   ALL METHODS HERE
    *
    * ================================================================================*/
    default ResponseEntity save(T var1) {
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

    default ResponseEntity getById(Class<T> type, Integer id) {
        System.out.println("-----------GET BY ID---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory("select").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            T var= (T) session.get(type,id);
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

    default ResponseEntity<List<T>> getAll(Class<T> type) {
        System.out.println("-----------GET ALL---------------");
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (Session session = hu.getSessionFactory("select").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            List<T> list= loadAllData(type, session);
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

    default ResponseEntity<T> delete(Class<T> type,Integer id) {
        Transaction transaction = null;
        HibernateUtil hu = new HibernateUtil();
        try (        Session session = hu.getSessionFactory("delete").openSession()){
            System.out.println("session " + session);

            transaction = session.beginTransaction();
            T var = (T) session.get(type,id);
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

    default ResponseEntity<T> update(T var1,Integer Id) {
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
