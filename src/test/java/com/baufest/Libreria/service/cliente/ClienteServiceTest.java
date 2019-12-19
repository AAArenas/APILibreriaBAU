package com.baufest.Libreria.service.cliente;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ClienteServiceTest {
    @MockBean
    private ClienteRepository mockRepository;
    @MockBean
    private ClienteService mockService;
    @Test
    void obtenerClienteId() {
        Cliente cliente = new Cliente(1,"test","test");
        when(mockRepository.findById(1)).thenReturn(Optional.of(cliente));
        Cliente emp = mockService.obtenerClienteId(1).orElse(null);
        if(emp != null) {
            assertEquals("test", emp.getName());
            assertEquals("test", emp.getDireccion());
            assertEquals(1, emp.getId());
        } else {
            System.out.println("Error");
        }
    }
}