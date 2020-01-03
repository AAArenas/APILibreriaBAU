package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.Factura;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RequestMapping("api/v1/suscripcion")
public class SuscripcionController {

    @Autowired
    SuscripcionService suscripcionService ;

    //List all suscripcion
    @GetMapping
    public ResponseEntity<List<Suscripcion>> getAllSuscripcions(){
            return suscripcionService.getAllSuscripcions();
    }

    //List one suscripcion
    @RequestMapping(value = "{suscripcionId}", method = RequestMethod.GET)
    public ResponseEntity<Suscripcion> getSuscripcion(@PathVariable("suscripcionId") Integer suscripcionId){
        return suscripcionService.getSuscripcionById(suscripcionId);
    }

    //Create new suscripcion
    @PostMapping
    public ResponseEntity<Suscripcion> createSuscripcion(@RequestBody Suscripcion suscripcion){
        return suscripcionService.save(suscripcion);
    }

    @DeleteMapping(value = "{suscripcionId}")
    //@RequestMapping(value = "{suscripcionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteSuscripcion(@PathVariable("suscripcionId") Integer suscripcionId){
        return suscripcionService.delete(suscripcionId);
    }

    @PutMapping(path = "{Id}")
    public ResponseEntity<Suscripcion> updateSuscripcion(@PathVariable("Id") Integer Id, @RequestBody Suscripcion suscripcion){
        return suscripcionService.update(Id, suscripcion);
    }

    @RequestMapping(path = "{Id}/generarFactura")
    public ResponseEntity<Factura> generarFactura(@PathVariable("Id") Integer Id){
        return suscripcionService.generarFactura(Id);
    }
}
