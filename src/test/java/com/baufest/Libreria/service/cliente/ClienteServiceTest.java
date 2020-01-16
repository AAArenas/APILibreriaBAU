package com.baufest.Libreria.service.cliente;

import com.baufest.Libreria.models.Cliente;
import com.baufest.Libreria.repository.ClienteRepository;
import com.baufest.Libreria.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;
    @MockBean
    private ClienteRepository mockRepository;

    @Test
    public void obtenerClientePorIdTest(){
        /*ResponseEntity<Cliente> cliente = new ResponseEntity<Cliente>(1,"test","test");
        when(mockRepository.getById(Cliente.class,1)).thenReturn(cliente);*/
        Cliente test = clienteService.getById(1).getBody();
        assertEquals("test", test.getName());
        assertEquals("test", test.getDireccion());
        assertEquals(1, test.getId());
    }
    @Test
    public void obtenerClientesTest() {
        Cliente cliente = new Cliente(1,"test","test");
        Cliente cliente2 = new Cliente(2,"test2","test2");
        Cliente cliente3 = new Cliente(3,"test3","test3");
        Cliente cliente4 = new Cliente(4,"test4","test4");
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);

        when(mockRepository.getAll(Cliente.class)).thenReturn((ResponseEntity) clientes);
        List<Cliente> test = clienteService.getAll().getBody();

        //Cliente 1
        assertEquals(cliente, test.get(0));
        //Cliente 2
        assertEquals(cliente2, test.get(1));
        //Cliente 3
        assertEquals(cliente3, test.get(2));
        //Cliente 4
        assertEquals(cliente4, test.get(3));
    }
    public void crearClienteTest(){
        /*Cliente cliente = new Cliente(1,"test","test");

        when(mockRepository.save(cliente)).thenReturn(ResponseEntity.of(cliente));

        Cliente clientereturn = clienteService.save(cliente).getBody();

        assertEquals(clientereturn,cliente);*/
    }
}