package com.baufest.Libreria.repository;
import com.baufest.Libreria.models.Suscripcion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SuscripcionRepository<S extends IClave > extends RepositoryCustom {

    @Query("select s from Suscripcion s where s.cliente.id = :clienteId")
    Optional <List<Suscripcion>> findByClienteId(@Param("clienteId") Integer clienteId);

}

