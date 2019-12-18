package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;


    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository= productoRepository;
    }

    public ResponseEntity<List<Producto>> findAll(){
        List<Producto> productos = productoRepository.findAll();
        return ResponseEntity.ok(productos);
    }

    public Long addProducto(Producto producto){
        return productoRepository.save(producto).getId();
    }

    

}
