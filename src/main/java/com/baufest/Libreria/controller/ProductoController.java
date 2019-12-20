package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return productoService.findAll();
    }

    @PostMapping
    public Integer agregarProducto(@RequestBody Producto producto){
        return productoService.agregarProducto(producto);
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public ResponseEntity<Producto> getProducto(@PathVariable("id") Integer id){
        System.out.println(id);
        return productoService.getProducto(id);
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Integer id){
        productoService.deleteProducto(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping(path="{id}")
    public ResponseEntity<?> editProducto(@PathVariable("id") Integer id, @RequestBody Producto producto){
        return productoService.editProducto(id, producto);
    }

}
