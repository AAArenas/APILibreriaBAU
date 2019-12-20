package com.baufest.Libreria.controller;

import com.baufest.Libreria.models.Producto;
import com.baufest.Libreria.repository.ProductoRepository;
import com.baufest.Libreria.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoControllerTest {

    @MockBean
    ProductoRepository productoRepository;

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoController productoController;

    List<Producto> productos = new ArrayList<Producto>();
    Producto producto1 = new Producto("Camilo", 1, 123);
    Producto producto2 = new Producto("Fran", 2, 200);
    Producto producto3 = new Producto("Martin", 3, 432);


    @Test
    void listarProductos() {

        producto1.setId(1);
        producto2.setId(2);
        producto3.setId(3);
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);


        Mockito.when(productoRepository.findAll())
                .thenReturn( productos);

        List<Producto> productosObtenidos = productoController.listarProductos().getBody();
        assertEquals(productosObtenidos,productos);
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