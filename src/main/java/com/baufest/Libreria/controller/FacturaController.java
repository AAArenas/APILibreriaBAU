package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Factura;
import com.baufest.Libreria.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/factura")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    // List All
    @RequestMapping(value = "/factura")
    public ResponseEntity<List<Factura>> getAllFactura() {
        return facturaService.getAllFactura();
    }

    // List One
    @RequestMapping(value = "/factura/{id}")
    public ResponseEntity<Factura> getFactura(@PathVariable Integer id) {
        return facturaService.getFactura(id);
    }

    // Create New
    @RequestMapping(value = "/factura", method = RequestMethod.POST)
    public ResponseEntity<Factura> saveFactura(@RequestBody Factura factura) {
        return facturaService.saveFactura(factura);
    }

    // Update with PUT
    @RequestMapping(value = "/factura/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Factura> updateFactura(@PathVariable Integer id, @RequestBody Factura factura) {
        return facturaService.updateFactura(id,factura );
    }

    // Delete
    @RequestMapping(value = "/factura/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFactura(@PathVariable Integer id) {
        return facturaService.deleteFactura(id);
    }
}
