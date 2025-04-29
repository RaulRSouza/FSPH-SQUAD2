package com.squad2.dtos;

import com.squad2.model.Status;
import com.squad2.model.TipoAmostra;

import java.time.LocalDateTime;

public record AmostraDto(String dataColeta, String horaColeta, String municipio, String coletor, String endereco, TipoAmostra tipoAmostra, Status status) {
}
