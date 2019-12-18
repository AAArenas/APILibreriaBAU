package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository= productoRepository;
    }

    public Integer agregarProducto(Producto producto){
        return this.productoRepository.agregarProducto(producto.getNombre());
    }

}
