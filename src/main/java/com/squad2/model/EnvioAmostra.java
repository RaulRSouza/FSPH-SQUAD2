package com.squad2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "envio_amostras")
public class EnvioAmostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String municipio;

    @Positive
    private int quantidadeAmostras;

    @NotBlank
    private String tipoAmostra;

    private String enderecoCaptura;

    @NotNull
    private LocalDate dataCaptura;

    private String insetoLarva;

    @Column(unique = true)
    private String protocolo;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Relacionamento com Município (para controle de acesso)
    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipioResponsavel;
}