package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.CuentaCorriente;
import com.baufest.Libreria.service.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/cuentacorriente")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CuentaCorrienteController {

    @Autowired
    CuentaCorrienteService cuentaCorrienteService;


    @PostMapping
    public ResponseEntity<CuentaCorriente> addCuentaCorriente(@RequestBody CuentaCorriente cuentaCorriente){

        return ResponseEntity.ok(cuentaCorrienteService.addCuentaCorriente(cuentaCorriente));
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

    /*
    @GetMapping (path = "/clienteid/{clienteid}")
    public ResponseEntity<CuentaCorriente> getCuentaCorrienteByClienteId(@PathVariable("clienteid") Integer id){
        Optional<CuentaCorriente> optionalCuentaCorriente = cuentaCorrienteService.getCuentaCorrienteByClienteId(id);
        if (optionalCuentaCorriente.isPresent()){
            return ResponseEntity.ok(optionalCuentaCorriente.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

*/
  /*
   @PutMapping
        public ResponseEntity<CuentaCorriente> updateCuentaCorriente(@RequestParam Integer id, @RequestBody CuentaCorriente cuentaCorrienteToUpdate) {
            Optional<CuentaCorriente> optionalCuentaCorriente = cuentaCorrienteService.getCuentaCorrienteById(id);
            if (optionalCuentaCorriente.isPresent()){
                return ResponseEntity.ok(cuentaCorrienteService.updateCuentaCorriente(id, cuentaCorrienteToUpdate).get());
            } else {
                return ResponseEntity.noContent().build();
            }
        }
*/



    @DeleteMapping(value ="{id}")
    public int deleteById(@PathVariable("id") Integer id){
        Optional<CuentaCorriente> cuentaEncontrada = cuentaCorrienteService.getCuentaCorrienteById(id);
        cuentaCorrienteService.deleteById(cuentaEncontrada);
        return 1;
    }



}
