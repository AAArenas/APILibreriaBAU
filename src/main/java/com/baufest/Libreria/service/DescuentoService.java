package com.baufest.Libreria.service;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.repository.RepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoService implements RepositoryCustom {

    @Autowired
    RepositoryCustom repositoryCustom;

    public ResponseEntity<Descuento> save(Descuento descuento){
        return repositoryCustom.save(descuento);
    }

    public ResponseEntity<Descuento> getById(Integer id){
        return repositoryCustom.getById(Descuento.class,id);
    }

    public ResponseEntity<List<Descuento>> getAll(){

        return repositoryCustom.getAll(Descuento.class);
    }

    public ResponseEntity<Descuento> delete(Integer id){
        return repositoryCustom.delete(Descuento.class,id);
    }

    public ResponseEntity<Descuento> update(Descuento descuento,Integer id){
        return repositoryCustom.update(descuento,id);
    }
}
