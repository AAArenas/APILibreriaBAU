package com.baufest.Libreria.repository;


import com.baufest.Libreria.models.Suscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SuscripcionRepository extends CustomRepositoryImpl<Suscripcion,Integer> {



    //@Query("select c from CuentaCorriente c where c.cliente.id = :clienteId")
    //Optional<CuentaCorriente> findByClienteId(@Param("clienteId") Integer clienteId);


}

