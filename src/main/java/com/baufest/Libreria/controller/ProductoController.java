package com.baufest.Libreria.controller;

import com.baufest.Libreria.errors.ValidationException;
import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.models.TipoProducto;
import com.baufest.Libreria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RequestMapping("api/v1/producto")
@RestController
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
        return productoService.deleteProducto(id);
    }

    @RequestMapping(value = "/tipos", method = RequestMethod.GET)
    public List<String> getTipos(){
        List<String> enumNames = Stream.of(TipoProducto.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return enumNames;
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
