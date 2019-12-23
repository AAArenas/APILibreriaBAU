package com.baufest.Libreria.repository;


import com.baufest.Libreria.models.SuscripcionModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionModel, Integer> {

}

