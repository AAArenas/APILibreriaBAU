package com.baufest.Libreria.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository<S extends IClave > extends RepositoryCustom {

}
