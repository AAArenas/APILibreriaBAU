package com.baufest.Libreria.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository<S extends IClave > extends RepositoryCustom {

}
