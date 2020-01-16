package com.baufest.Libreria.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository<S extends IClave > extends RepositoryCustom {


}
