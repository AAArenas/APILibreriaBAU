package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.baufest.Libreria.service.cuentacorriente.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/cuentacorriente")
@RestController
public class CuentaCorrienteController {

        private final CuentaCorrienteService cuentaCorrienteService;

        @Autowired
        public CuentaCorrienteController(CuentaCorrienteService cuentaCorrienteService) {
            this.cuentaCorrienteService = cuentaCorrienteService;
        }

        @PostMapping
        public int save(CuentaCorriente cuentaCorriente){
            cuentaCorrienteService.save(cuentaCorriente);
            return 1;
        }


        @GetMapping
        public ResponseEntity<ArrayList<CuentaCorriente>> findAll (){
            CuentaCorriente cuenta = new CuentaCorriente("camilo");
            ArrayList<CuentaCorriente> cuentasCorrientes = new ArrayList<>();
            cuentasCorrientes.add(cuenta);
            return ResponseEntity.ok(cuentasCorrientes);

    }


}


