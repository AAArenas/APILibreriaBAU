package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
