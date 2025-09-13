package com.upc.data_jpa_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "responsables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relación 1:1 con Categoria
    @OneToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
