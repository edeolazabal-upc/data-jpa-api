package com.upc.data_jpa_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productoInsertaDTO {
    private Long id;
    private String nombre;
    private double precio;
    private Long categoria_id;
}
