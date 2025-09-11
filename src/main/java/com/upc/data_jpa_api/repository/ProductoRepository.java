package com.upc.data_jpa_api.repository;

import com.upc.data_jpa_api.model.Categoria;
import com.upc.data_jpa_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
