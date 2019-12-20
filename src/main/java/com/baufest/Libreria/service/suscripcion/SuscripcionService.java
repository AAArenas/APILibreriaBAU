package com.baufest.Libreria.service.suscripcion;

import com.baufest.Libreria.models.SuscripcionModel;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    SuscripcionRepository suscripcionRepository;

    public ResponseEntity<List<SuscripcionModel>> getAllSuscripcions() {
        List<SuscripcionModel> suscripciones = suscripcionRepository.findAll();
        return ResponseEntity.ok(suscripciones);
    }

    public ResponseEntity<SuscripcionModel> getSuscripcionById(Integer suscripcionId) {
        Optional<SuscripcionModel> optionalSuscripcionModel = suscripcionRepository.findById(suscripcionId);
        if (optionalSuscripcionModel.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optionalSuscripcionModel.get());
    }

    public ResponseEntity<SuscripcionModel> save(SuscripcionModel suscripcion) {
        SuscripcionModel nuevaSuscripcion = suscripcionRepository.save(suscripcion);
        return ResponseEntity.ok(nuevaSuscripcion);
    }

    public ResponseEntity<Void> delete(Integer suscripcionId) {
        suscripcionRepository.deleteById(suscripcionId);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<SuscripcionModel> update(Integer Id, SuscripcionModel suscripcionModel) {
        //if (suscripcionModel.get) Fixme: validar... que validar?
        if (suscripcionRepository.existsById(Id)) {
            suscripcionModel.setId(Id);
            return ResponseEntity.ok(suscripcionRepository.save(suscripcionModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
