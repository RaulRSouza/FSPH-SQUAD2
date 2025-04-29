package com.squad2.model;

import com.squad2.dtos.AmostraDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "amostras")
@Inheritance(strategy = InheritanceType.JOINED)
public class Amostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_coleta", nullable = false)
    private String dataColeta;

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
    public Amostra(AmostraDto amostra, TipoAmostra tipoAmostra, Status status) {
        this.dataColeta = amostra.dataColeta();
        this.horaColeta = amostra.horaColeta();
        this.municipio = amostra.municipio();
        this.coletor = amostra.coletor();
        this.endereco = amostra.endereco();
        this.tipoAmostra = tipoAmostra;
        this.status = status; // <-- NOVO PARÂMETRO
    }
}