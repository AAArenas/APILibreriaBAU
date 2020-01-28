package com.baufest.Libreria.service;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoService {

    @Autowired
    DescuentoRepository descuentoRepository;

    public ResponseEntity<Descuento> save(Descuento descuento){
        return descuentoRepository.save(descuento);
    }

    public ResponseEntity<Descuento> getById(Integer id){
        return descuentoRepository.getById(Descuento.class,id);
    }

    public ResponseEntity<List<Descuento>> getAll(){
        return descuentoRepository.getAll(Descuento.class);
    }

    public ResponseEntity<Descuento> delete(Integer id){
        return descuentoRepository.delete(Descuento.class,id);
    }

    public ResponseEntity<Descuento> update(Descuento descuento,Integer id){
        return descuentoRepository.update(descuento,id);
    }
}
