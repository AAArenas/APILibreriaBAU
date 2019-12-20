package com.baufest.Libreria.service;

import com.baufest.Libreria.errors.ValidationException;
import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Producto> productos = productoRepository.findAll();
        return ResponseEntity.ok(productos);
    }

    public ResponseEntity<Integer> agregarProducto(Producto producto){
        if (producto.getNombre().isBlank() || producto.getTipo().isBlank()){
            throw new ValidationException("No podés meter un producto vacio, forro");
        }
        return ResponseEntity.ok(productoRepository.save(producto).getId());
    }

    public ResponseEntity<Producto> getProducto(Integer id){
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if(optionalProducto.isPresent()){
            return ResponseEntity.ok(optionalProducto.get());
        } else {
            throw new ValidationException("No hay usuario con este id");
        }
    }

    public ResponseEntity<?> deleteProducto(Integer id){
        Producto producto = this.getProducto(id).getBody();
        productoRepository.delete(producto);
        return ResponseEntity.ok().build();
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
