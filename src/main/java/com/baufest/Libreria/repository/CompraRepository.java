package com.baufest.Libreria.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository<S extends IClave > extends RepositoryCustom {
}


