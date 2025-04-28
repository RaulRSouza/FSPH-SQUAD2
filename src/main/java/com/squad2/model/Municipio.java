package com.squad2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "municipios")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String usuario;

    private String senha;

    // Papel padrão (ROLE_MUNICIPIO)
    private String role = "ROLE_MUNICIPIO";
}