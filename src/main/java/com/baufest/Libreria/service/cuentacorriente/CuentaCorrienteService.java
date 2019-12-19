package com.baufest.Libreria.service.cuentacorriente;

import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.baufest.Libreria.repository.cuentacorriente.CuentaCorrienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaCorrienteService {

    @Autowired
    private final CuentaCorrienteDao cuentaCorrienteDao;

    public CuentaCorrienteService(CuentaCorrienteDao cuentaCorrienteDao) {
        this.cuentaCorrienteDao = cuentaCorrienteDao;
    }

    public int save(CuentaCorriente cuentaCorriente){
         cuentaCorrienteDao.save(cuentaCorriente);
         return 1;
    }

  /*  public ResponseEntity<List<CuentaCorriente>> findAll(){
        List<CuentaCorriente> cuentasCorrientes = cuentaCorrienteDao.findAll();
        return ResponseEntity.ok(cuentasCorrientes);
    }


*/

    public ResponseEntity<ArrayList<CuentaCorriente>> findAll(){
        CuentaCorriente cuenta = new CuentaCorriente("camilo");
        ArrayList<CuentaCorriente> cuentasCorrientes = new ArrayList<>();
        cuentasCorrientes.add(cuenta);
        return ResponseEntity.ok(cuentasCorrientes);
    }
}
