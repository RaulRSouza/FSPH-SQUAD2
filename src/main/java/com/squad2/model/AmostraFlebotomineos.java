package com.squad2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "amostras_flebotomineos")
@EqualsAndHashCode(callSuper = true)
public class AmostraFlebotomineos extends Amostra {

    // Classificação da área
    private String classificacaoAreaLV;
    private String classificacaoAreaLT;

    // Tipo de atividade
    private String tipoAtividadeLV;
    private String tipoAtividadeLT;

    // Dados gerais
    private String uf;
    private String codigoMunicipio;
    private String nomeMunicipio;

    private String codigoLocalidade;
    private String nomeLocalidade;
    private String categoriaLocalidade;

    private String nomeMorador;
    private String telefone;
    private String enderecoCompleto;

    private String latitude;
    private String longitude;
    private String altitude;

    // Dados ambientais
    private String tipoVegetacao;
    private String distanciaVegetacao;

    private String temperaturaChegada;
    private String temperaturaSaida;
    private String temperaturaMax;
    private String temperaturaMin;

    private String umidadeChegada;
    private String umidadeSaida;
    private String umidadeMax;
    private String umidadeMin;

    private String faseLua;
    private String vento;

    private boolean presencaAnimalIntraCaes;
    private boolean presencaAnimalIntraAves;
    private boolean presencaAnimalIntraSuinos;

    private boolean presencaAnimalPeriCaes;
    private boolean presencaAnimalPeriAves;
    private boolean presencaAnimalPeriSuinos;

    private boolean possuiGalinheiro;

    private String estacaoAno;

    private boolean acumuloMateriaOrganica;
    private boolean precipitacao;

    private String observacao;

    // Construtor herdado
    public AmostraFlebotomineos(
        java.time.LocalDateTime dataColeta,
        String horaColeta,
        String municipio,
        String coletor,
        String endereco,
        TipoAmostraEnum tipoAmostra,
        StatusEnvio status
    ) {
        super(dataColeta, horaColeta, municipio, coletor, endereco, tipoAmostra, status);
    }
}
