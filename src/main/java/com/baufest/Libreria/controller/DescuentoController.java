package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.Descuento;
import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.service.DescuentoService;
import com.baufest.Libreria.service.SuscripcionService;
import javassist.runtime.Desc;
import org.hibernate.mapping.Any;
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

    //List all descuentos
    @GetMapping
    public ResponseEntity<List<Descuento>> getAllSuscripcions(){
            return descuentoService.getAll();
    }

    //List one descuento
    @RequestMapping(value = "{descuentoId}", method = RequestMethod.GET)
    public ResponseEntity<Descuento> getDescuento(@PathVariable("descuentoId") Integer descuentoId){
        return descuentoService.getById(descuentoId);
    }

    //Create new Descuento
    @PostMapping
    public ResponseEntity<Descuento> createDescuento(@RequestBody Descuento descuento){
        return descuentoService.save(descuento);
    }

    @DeleteMapping(value = "{descuentoId}")
    //@RequestMapping(value = "{suscripcionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Descuento> deleteDescuento(@PathVariable("descuentoId") Integer descuentoId){
       return descuentoService.delete(descuentoId);
    }

    @PutMapping(path = "{Id}")
    public ResponseEntity<Descuento> update(@PathVariable("Id") Integer Id, @RequestBody Descuento descuento){
        return descuentoService.update(descuento, Id);
    }
}
