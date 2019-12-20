package com.baufest.Libreria.service;

import com.baufest.Libreria.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoServiceTest {

    @MockBean
    ProductoRepository productoRepository;

    @Autowired
    ProductoService productoService;

    @Test
    void findAll() throws exception {
    }

    @Test
    void agregarProducto() {
    }

    @Test
    void getProducto() {
    }

    @Test
    void deleteProducto() {
    }

    @Test
    void editProducto() {
    }
}