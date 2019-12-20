package com.baufest.Libreria.service;

import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

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

    public Integer agregarProducto(Producto producto){
        return productoRepository.save(producto).getId();
    }

    public ResponseEntity<Producto> getProducto(Integer id){
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if(optionalProducto.isPresent()){
            return ResponseEntity.ok(optionalProducto.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public void deleteProducto(Integer id){
        Producto producto = this.getProducto(id).getBody();
        productoRepository.delete(producto);
    }

    public ResponseEntity<?> editProducto(Integer id, Producto producto){
        Producto productoViejo = this.getProducto(id).getBody();
        System.out.println(productoViejo.getNombre());
        Producto productoNuevo = producto;
        productoViejo.setNombre(productoNuevo.getNombre());
        productoViejo.setPrecio(productoNuevo.getPrecio());
        productoViejo.setTipo(productoNuevo.getTipo());
        return ResponseEntity.ok(productoRepository.save(productoViejo).getId());
    }


}
