package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Producto;
import java.util.ArrayList;

public interface IProductoRepository {
    Integer agregarProducto(String nombreProducto);
    /* ArrayList<Producto> listarProducto();
    Producto listarProducto(Integer id);
    Producto editarProducto(Integer id);
    void eliminarProducto(Integer id);
    */

}
