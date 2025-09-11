package com.upc.data_jpa_api.service;

import com.upc.data_jpa_api.model.Producto;
import com.upc.data_jpa_api.model.ProductoDTO;
import com.upc.data_jpa_api.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public List<ProductoDTO> buscarNombre(String nombre) {
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        ProductoDTO productoDTO;
        for (Producto producto : productos) {
            productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            //log.info("id"+ producto.getId());
            productoDTO.setNombre(producto.getNombre());
            //log.info("nombre"+ producto.getNombre());
            productoDTO.setPrecio(producto.getPrecio());
            //log.info("precio"+ producto.getPrecio());
            //log.info("id DTO"+ productoDTO.getId());
            //log.info("nombre DTO"+ productoDTO.getNombre());
            //log.info("precio DTO"+ productoDTO.getPrecio());
            productoDTOs.add(productoDTO);
        }
        return productoDTOs;
    }
    public Producto insertar(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        return  productoRepository.save(producto);

    }

}
