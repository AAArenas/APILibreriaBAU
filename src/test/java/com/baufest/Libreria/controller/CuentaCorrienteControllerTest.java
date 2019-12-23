package com.baufest.Libreria.controller;


import com.baufest.Libreria.models.cuentacorriente.CuentaCorriente;
import com.baufest.Libreria.repository.cuentacorriente.CuentaCorrienteRepository;
import com.baufest.Libreria.service.cuentacorriente.CuentaCorrienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;



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
    void findAll (){


    }



}

