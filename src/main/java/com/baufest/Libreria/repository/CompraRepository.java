package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
}


