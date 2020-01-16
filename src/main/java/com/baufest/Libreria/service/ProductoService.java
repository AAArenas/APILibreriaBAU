package com.baufest.Libreria.service;

import com.baufest.Libreria.errors.ValidationException;
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


   /* public ProductoService(ProductoRepository productoRepository){
        this.productoRepository= productoRepository;
    }*/

    public ResponseEntity<List<Producto>> findAll(){
        return productoRepository.getAll(Producto.class);
    }

    public ResponseEntity<Integer> agregarProducto(Producto producto){
        if (producto.getNombre().isBlank() || producto.getTipo().isBlank()){
            throw new ValidationException("No podés meter un producto vacio");
        }
        return productoRepository.save(producto);
    }

    public ResponseEntity<Producto> getProducto(Integer id){
        return productoRepository.getById(Producto.class,id);
    }

    public ResponseEntity<?> deleteProducto(Integer id){
        return productoRepository.delete(Producto.class,id);
    }

    public ResponseEntity<?> editProducto(Integer id, Producto producto){
        Producto productoViejo = this.getProducto(id).getBody();
        System.out.println(productoViejo.getNombre());
        Producto productoNuevo = producto;
        productoViejo.setNombre(productoNuevo.getNombre());
        productoViejo.setPrecio(productoNuevo.getPrecio());
        productoViejo.setTipo(productoNuevo.getTipo());
        return ResponseEntity.ok(this.agregarProducto(productoViejo));
    }
}
