package com.baufest.Libreria.repository;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@NoRepositoryBean
public interface RepositoryCustom<T extends IClave,ID> extends Repository<T ,ID> {


    ResponseEntity save(T var1);

    ResponseEntity getById(Class<T> type, ID id);

    ResponseEntity<List<T>> getAll(Class<T> type);

    ResponseEntity<T> delete(Class<T> type, ID id);

    ResponseEntity<T> update(IClave var1, ID Id);
}