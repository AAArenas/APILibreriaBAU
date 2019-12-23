package com.baufest.Libreria.service.suscripcion;

import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    SuscripcionRepository suscripcionRepository;

    public ResponseEntity<List<Suscripcion>> getAllSuscripcions() {
        List<Suscripcion> suscripciones = suscripcionRepository.findAll();
        return ResponseEntity.ok(suscripciones);
    }

    public ResponseEntity<Suscripcion> getSuscripcionById(Integer suscripcionId) {
        Optional<Suscripcion> optionalSuscripcionModel = suscripcionRepository.findById(suscripcionId);
        if (optionalSuscripcionModel.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optionalSuscripcionModel.get());
    }

    public ResponseEntity<Suscripcion> save(Suscripcion suscripcion) {
        Suscripcion nuevaSuscripcion = suscripcionRepository.save(suscripcion);
        return ResponseEntity.ok(nuevaSuscripcion);
    }

    public  ResponseEntity<Integer> delete(Integer suscripcionId) {
        try {
            suscripcionRepository.deleteById(suscripcionId);
            return ResponseEntity.ok(suscripcionId);
        } catch (EmptyResultDataAccessException exc) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }

    public ResponseEntity<Suscripcion> update(Integer Id, Suscripcion suscripcion) {
        //if (suscripcion.get) Fixme: validar... que validar?
        if (suscripcionRepository.existsById(Id)) {
            suscripcion.setId(Id);
            return ResponseEntity.ok(suscripcionRepository.save(suscripcion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
