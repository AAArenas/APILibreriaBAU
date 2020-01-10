package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.service.DescuentoService;
import com.baufest.Libreria.service.SuscripcionService;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RequestMapping("api/v1/descuento")
public class DescuentoController {

    @Autowired
    DescuentoService descuentoService ;

    //List all suscripcion
    @GetMapping
    public ResponseEntity<List<Descuento>> getAllSuscripcions(){
            return descuentoService.obtenerDescuentos();
    }

    //List one suscripcion
    @RequestMapping(value = "{suscripcionId}", method = RequestMethod.GET)
    public ResponseEntity<Descuento> getSuscripcion(@PathVariable("descuentoId") Integer descuentoId){
        return descuentoService.getDescuentoById(descuentoId);
    }

    //Create new suscripcion
    @PostMapping
    public ResponseEntity<Descuento> createSuscripcion(@RequestBody Descuento descuento){
        return descuentoService.crearDescuento(descuento);
    }

    @DeleteMapping(value = "{descuentoId}")
    //@RequestMapping(value = "{suscripcionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteSuscripcion(@PathVariable("descuentoId") Integer descuentoId){
        return descuentoService.delete(descuentoId);
    }
/*
    @PutMapping(path = "{Id}")
    public ResponseEntity<Suscripcion> updateSuscripcion(@PathVariable("Id") Integer Id, @RequestBody Suscripcion suscripcion){
        return descuentoService.update(Id, suscripcion);
    }*/
}
