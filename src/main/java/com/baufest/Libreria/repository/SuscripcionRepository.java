package com.baufest.Libreria.repository;


import com.baufest.Libreria.models.SuscripcionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionDB, Integer> {

}

