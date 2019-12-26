/*package com.baufest.Libreria.service.suscripcion;

import com.baufest.Libreria.models.Suscripcion;
import com.baufest.Libreria.repository.SuscripcionRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SuscripcionServiceTest {

    @Autowired
    private SuscripcionService suscripcionService;
    @MockBean
    private SuscripcionRepository mockRepository;

    @Test
    void sePuedeGuardarUnaSuscripcionTest() {

        LocalDate finalizacion = LocalDate.of(2020, 3, 11);
        Suscripcion suscripcionTest = new Suscripcion(2, finalizacion);

        when(mockRepository.save(suscripcionTest)).thenReturn(suscripcionTest);

        assertEquals(suscripcionService.save(suscripcionTest).getBody(), suscripcionTest );

    }

    @Test
    void getSuscripcionByIdTest() {

        LocalDate finalizacion = LocalDate.of(2020, 3, 11);
        Suscripcion suscripcionTest = new Suscripcion(2, finalizacion);
        suscripcionTest.setId(1);

        when(mockRepository.findById(1)).thenReturn(Optional.of(suscripcionTest));
        Suscripcion suscripcionReturn = suscripcionService.getSuscripcionById(1).getBody();

        assertEquals(suscripcionReturn, suscripcionTest);

    }

    @Test
    void getAllSuscripcionsTest() {

        LocalDate finalizacion1 = LocalDate.of(2021, 3, 11);
        LocalDate finalizacion2 = LocalDate.of(2022, 3, 11);
        LocalDate finalizacion3 = LocalDate.of(2023, 3, 11);

        Suscripcion suscripcionTest1 = new Suscripcion(2, finalizacion1);
        Suscripcion suscripcionTest2 = new Suscripcion(4, finalizacion2);
        Suscripcion suscripcionTest3 = new Suscripcion(8, finalizacion3);

        List<Suscripcion> suscripcionesTest = new ArrayList<Suscripcion>();

        suscripcionesTest.add(suscripcionTest1);
        suscripcionesTest.add(suscripcionTest2);
        suscripcionesTest.add(suscripcionTest3);

        when(mockRepository.findAll()).thenReturn(suscripcionesTest);
        List<Suscripcion> suscripcionReturn = suscripcionService.getAllSuscripcions().getBody();

        assertEquals(suscripcionesTest,suscripcionReturn);

    }

    @Test
    void delete() {

        LocalDate finalizacion = LocalDate.of(2020, 3, 11);
        Suscripcion suscripcionTest = new Suscripcion(2, finalizacion);
        suscripcionTest.setId(1);

        Mockito.when(mockRepository.deleteById(1)).thenReturn(null);
        Suscripcion suscripcionReturn = suscripcionService.getSuscripcionById(1).getBody();

        assertEquals(suscripcionReturn, suscripcionTest);


    }

    @Test
    void update() {

    }
}*/