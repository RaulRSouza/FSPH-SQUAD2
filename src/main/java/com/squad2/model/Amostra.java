package com.squad2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "amostras")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Amostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_coleta", nullable = false)
    private LocalDateTime dataColeta;

    @Column(name = "hora_coleta", nullable = false)
    private String horaColeta;

    @Column(nullable = false)
    private String municipio;
    
    @Column(nullable = false)
    private String coletor;

    @Column(nullable = false)
    private String endereco;

// Relacionamento com TipoAmostra
@ManyToOne
@JoinColumn(name = "tipo_amostra_id", nullable = false)
private TipoAmostra tipoAmostra;

// Relacionamento com Status
@ManyToOne
@JoinColumn(name = "status_id", nullable = false)
private Status status;

    // Construtor 
    public Amostra(LocalDateTime dataColeta, String horaColeta, String municipio, 
                   String coletor, String endereco, TipoAmostra tipoAmostra, Status status) {
        this.dataColeta = dataColeta;
        this.horaColeta = horaColeta;
        this.municipio = municipio;
        this.coletor = coletor;
        this.endereco = endereco;
        this.tipoAmostra = tipoAmostra;
        this.status = status; // <-- NOVO PARÂMETRO
    }
}