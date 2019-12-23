package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Factura;
import com.baufest.Libreria.repository.FacturaRepository;
import com.baufest.Libreria.service.FacturaService;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.accessibility.AccessibleStateSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacturaControllerTest {

    @Autowired
    FacturaController facturaController;

    @MockBean
    FacturaService facturaService;

    @Test
    public void ControllerGetFactura(){

        Factura f = new Factura();

        Mockito.when(facturaService.getFactura(1)).thenReturn(ResponseEntity.of(Optional.of(f)));

        Assert.assertSame(f,facturaController.getFactura(1).getBody());

    }

    @Test
    public void ControllerGetAllFactura(){

        List<Factura> f = new ArrayList<>();

        Mockito.when(facturaService.getAllFactura()).thenReturn(ResponseEntity.of(Optional.of(f)));

        Assert.assertSame(f, facturaController.getAllFactura().getBody());
    }

    @Test
    public void ControllerSaveFactura(){
        Factura f = new Factura();

        Mockito.when(facturaService.saveFactura(f)).thenReturn(ResponseEntity.of(Optional.of(f)));

        Assert.assertSame(f, facturaController.saveFactura(f).getBody());
    }

    @Test
    public void ControllerUpdateFactura(){
        Factura f = new Factura(200.0, LocalDate.now());

        Mockito.when(facturaService.updateFactura(1,f)).thenReturn(ResponseEntity.of(Optional.of(f)));

        Assert.assertSame(f,facturaController.saveFactura(f).getBody());
    }

    @Test
    public void ControllerDeleteFactura(){
        Mockito.doNothing().when(facturaService.deleteFactura(1));
    }
}
