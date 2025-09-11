package com.upc.data_jpa_api.controller;

import com.upc.data_jpa_api.model.ProductoDTO;
import com.upc.data_jpa_api.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO productoDTO) {
        return new ResponseEntity(productoService.insertar(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<ProductoDTO>> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(productoService.buscarNombre(nombre), HttpStatus.OK);
    }


}
