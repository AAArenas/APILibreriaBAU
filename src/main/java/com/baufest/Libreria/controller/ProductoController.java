package com.baufest.Libreria.controller;

import com.baufest.Libreria.errors.ValidationException;
import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

   /* public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }*/

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return productoService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> agregarProducto(@RequestBody Producto producto){
        try {
            return productoService.agregarProducto(producto);
        } catch(ValidationException exception){
            return ResponseEntity.badRequest().body(exception.getMsg());
        }
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public ResponseEntity<?> getProducto(@PathVariable("id") Integer id){
        try {
            return productoService.getProducto(id);
        } catch(ValidationException exception){
            return ResponseEntity.badRequest().body(exception.getMsg());
        }
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Integer id){
        try {
            return productoService.deleteProducto(id);
        } catch(ValidationException exception){
            return ResponseEntity.badRequest().body(exception.getMsg());
        }
    }

    @PutMapping(path="{id}")
    public ResponseEntity<?> editProducto(@PathVariable("id") Integer id, @RequestBody Producto producto){
        try {
            return productoService.editProducto(id, producto);
        } catch(ValidationException exception){
            return ResponseEntity.badRequest().body(exception.getMsg());
        }

    }

}
