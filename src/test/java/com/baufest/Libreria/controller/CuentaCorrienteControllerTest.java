package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.baufest.Libreria.repository.cuentacorriente.CuentaCorrienteRepository;
import com.baufest.Libreria.service.cuentacorriente.CuentaCorrienteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.filter.MockCandidateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;


@RunWith(SpringRunner.class)
@SpringBootTest
class CuentaCorrienteControllerTest {


    @MockBean
    CuentaCorrienteRepository cuentaCorrienteRepository;
    @Autowired
    CuentaCorrienteService cuentaCorrienteService;
    @Autowired
    CuentaCorrienteController cuentaCorrienteController;

    CuentaCorriente mockCuentaCorriente = new CuentaCorriente("Gerardo");


    @Test
    void getCuentaCorrienteById() {
        mockCuentaCorriente.setId(1);

        Mockito.when(cuentaCorrienteRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(mockCuentaCorriente));
        CuentaCorriente cuentaObtenida = cuentaCorrienteController.getCuentaCorrienteById(1).getBody();
        assertEquals(cuentaObtenida, mockCuentaCorriente);

    }

    @Test
    void addCuentaCorriente(){
        CuentaCorriente mockCuentaCorriente = new CuentaCorriente("Juan");
        mockCuentaCorriente.setId(2);


        Mockito.when(cuentaCorrienteRepository.save(mockCuentaCorriente)).thenReturn(mockCuentaCorriente);
        CuentaCorriente cuentaObtenida = cuentaCorrienteController.addCuentaCorriente(mockCuentaCorriente).getBody();

        assertEquals(cuentaObtenida, mockCuentaCorriente);

    }

    @Test
    void findAll (){
        List<CuentaCorriente> cuentasCorrientes = cuentaCorrienteRepository.findAll();
        assertThat(cuentasCorrientes.size(), is(greaterThanOrEqualTo(0)));

    }



}

