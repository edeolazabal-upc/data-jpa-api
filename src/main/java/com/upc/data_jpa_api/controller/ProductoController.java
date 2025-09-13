package com.upc.data_jpa_api.controller;

import com.upc.data_jpa_api.model.Producto;
import com.upc.data_jpa_api.model.ProductoDTO;
import com.upc.data_jpa_api.model.productoInsertaDTO;
import com.upc.data_jpa_api.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> create(@RequestBody  ProductoDTO productoDTO) {
        return new ResponseEntity(productoService.insertar(productoDTO), HttpStatus.CREATED);
    }
    @PostMapping("/inserta")
    public ResponseEntity<Producto> createProducto(@RequestBody  Producto producto) {
        return new ResponseEntity(productoService.guardarProducto(producto), HttpStatus.CREATED);
    }
    @PostMapping("/inserta-cat")
    public ResponseEntity<Producto> createProducto(@RequestBody productoInsertaDTO producto) {
        return new ResponseEntity(productoService.guardarProductoCat(producto), HttpStatus.CREATED);
    }


    @GetMapping("/{nombre}")
    public ResponseEntity<List<ProductoDTO>> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(productoService.buscarNombre(nombre), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return new ResponseEntity<>(productoService.obtenerProductos(), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.warn("Solicitud DELETE para eliminar producto con ID: {}", id);
        return new ResponseEntity<>(productoService.eliminarProducto(id), HttpStatus.OK);
    }



}
