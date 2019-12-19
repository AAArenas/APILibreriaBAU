package com.baufest.Libreria.repository.cuentacorriente;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CuentaCorrienteDao extends JpaRepository <CuentaCorriente, Integer> {



}
