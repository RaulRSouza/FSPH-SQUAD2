package com.squad2.model;

import com.squad2.dtos.EditarLaminaDto;
import com.squad2.dtos.LaminaDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "amostras")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lamina {

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

    @Column(nullable = false)
    private Integer numeroOvos;

    public Lamina(LaminaDto dados){
        this.dataColeta = dados.dataColeta();
        this.horaColeta = dados.horaColeta();
        this.municipio = dados.municipio();
        this.coletor = dados.coletor();
        this.numeroOvos = dados.numeroOvos();
    }

    public void editarLamina(EditarLaminaDto dados){
        this.id = dados.id();
        this.dataColeta = dados.dataColeta();
        this.horaColeta = dados.horaColeta();
        this.municipio = dados.municipio();
        this.coletor = dados.coletor();
        this.numeroOvos = dados.numeroOvos();
    }
}
