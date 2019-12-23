package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.baufest.Libreria.service.cuentacorriente.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/cuentacorriente")
@RestController
public class CuentaCorrienteController {

        private final CuentaCorrienteService cuentaCorrienteService;

        @Autowired
        public CuentaCorrienteController(CuentaCorrienteService cuentaCorrienteService) {
            this.cuentaCorrienteService = cuentaCorrienteService;
        }

        @PostMapping
        public int addCuentaCorriente(@RequestBody CuentaCorriente cuentaCorriente){
            cuentaCorrienteService.addCuentaCorriente(cuentaCorriente);
            return 1;
        }


        @GetMapping
        public ResponseEntity<List<CuentaCorriente>> findAll (){
            return ResponseEntity.ok(cuentaCorrienteService.findAll());

        }

        @GetMapping (path = "/{id}")
        public ResponseEntity<CuentaCorriente> getCuentaCorrienteById(@PathVariable("id") Integer id) {
            Optional<CuentaCorriente> optionalCuentaCorriente = cuentaCorrienteService.getCuentaCorrienteById(id);
            if (optionalCuentaCorriente.isPresent()){
                return ResponseEntity.ok(optionalCuentaCorriente.get());
            } else {
                return ResponseEntity.noContent().build();
            }

        }

        @PutMapping
        public ResponseEntity<CuentaCorriente> updateCuentaCorriente(@RequestParam Integer id, @RequestBody CuentaCorriente cuentaCorrienteToUpdate) {
            Optional<CuentaCorriente> optionalCuentaCorriente = cuentaCorrienteService.getCuentaCorrienteById(id);
            if (optionalCuentaCorriente.isPresent()){
                return ResponseEntity.ok(cuentaCorrienteService.updateCuentaCorriente(id, cuentaCorrienteToUpdate).get());
            } else {
                return ResponseEntity.noContent().build();
            }
        }


        @DeleteMapping
        public int deleteById(@RequestParam Integer id){
            Optional<CuentaCorriente> cuentaEncontrada = cuentaCorrienteService.getCuentaCorrienteById(id);
            cuentaCorrienteService.deleteById(cuentaEncontrada);
            return 1;
        }



}


