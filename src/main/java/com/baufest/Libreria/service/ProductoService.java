package com.baufest.Libreria.service;

import com.baufest.Libreria.errors.ValidationException;
import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private  ProductoRepository productoRepository;


    public ResponseEntity<Producto> save(Producto producto){
        return productoRepository.save(producto);
    }

    public ResponseEntity<Producto> getById(Integer id){
        return productoRepository.getById(Producto.class,id);
    }

    public ResponseEntity<List<Producto>> getAll(){

        return productoRepository.getAll(Producto.class);
    }

    public ResponseEntity<Producto> delete(Integer id){
        return productoRepository.delete(Producto.class,id);
    }

    public ResponseEntity<Producto> update(Producto producto,Integer id){
        return productoRepository.update(producto,id);
    }
}
