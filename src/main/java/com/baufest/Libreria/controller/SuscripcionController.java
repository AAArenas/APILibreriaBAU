package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.SuscripcionModel;
import com.baufest.Libreria.service.suscripcion.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class SuscripcionController {

    @Autowired
    SuscripcionService suscripcionService ;

    //List all suscripcion
    @GetMapping
    public ResponseEntity<List<SuscripcionModel>> getAllSuscripcions(){
            return suscripcionService.getAllSuscripcions();
    }

    //List one suscripcion
    @RequestMapping(value = "{suscripcionId}", method = RequestMethod.GET)
    public ResponseEntity<SuscripcionModel> getSuscripcion(@PathVariable("suscripcionId") Integer suscripcionId){
        return suscripcionService.getSuscripcionById(suscripcionId);
    }

    //Create new suscripcion
    @PostMapping
    public ResponseEntity<SuscripcionModel> createSuscripcion(@RequestBody SuscripcionModel suscripcion){
        return suscripcionService.save(suscripcion);
    }

    @DeleteMapping(value = "{suscripcionId}")
    //@RequestMapping(value = "{suscripcionId}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteSuscripcion(@PathVariable("suscripcionId") Integer suscripcionId){
        return suscripcionService.delete(suscripcionId);
    }

    @PutMapping(path = "{Id}")
    public ResponseEntity<SuscripcionModel> updateSuscripcion(@PathVariable("Id") Integer Id,@RequestBody SuscripcionModel suscripcionModel){
        return suscripcionService.update(Id, suscripcionModel);
    }
}
