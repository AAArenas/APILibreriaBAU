package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaCorrienteRepository extends JpaRepository <CuentaCorriente, Integer> {


}
