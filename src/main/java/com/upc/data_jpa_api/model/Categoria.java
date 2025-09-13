package com.upc.data_jpa_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Responsable responsable;}
