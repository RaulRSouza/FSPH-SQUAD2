package com.squad2.dto;

import com.squad2.model.StatusEnvio;
import com.squad2.model.TipoAmostraEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AmostraResponseDTO {
    private Long id;
    private LocalDateTime dataColeta;
    private String horaColeta;
    private String municipio;
    private String coletor;
    private String endereco;
    private TipoAmostraEnum tipoAmostra;
    private StatusEnvio status;
}
