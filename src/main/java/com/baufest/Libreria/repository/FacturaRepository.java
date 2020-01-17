package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Factura;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends RepositoryCustom<Factura,Integer> {

}
