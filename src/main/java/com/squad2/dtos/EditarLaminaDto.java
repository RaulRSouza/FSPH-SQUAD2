package com.squad2.dtos;

public record EditarLaminaDto(Long id, String dataColeta, String horaColeta, String municipio, String coletor, String endereco, Integer numeroOvos) {
}
