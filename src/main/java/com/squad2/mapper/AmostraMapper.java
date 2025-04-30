package com.squad2.mapper;

import com.squad2.dto.AmostraRequestDTO;
import com.squad2.dto.AmostraResponseDTO;
import com.squad2.model.Amostra;
import com.squad2.model.AmostraFlebotomineos;


public class AmostraMapper {

    public static AmostraResponseDTO toResponseDTO(Amostra amostra) {
        AmostraResponseDTO dto = new AmostraResponseDTO();
        dto.setId(amostra.getId());
        dto.setDataColeta(amostra.getDataColeta());
        dto.setHoraColeta(amostra.getHoraColeta());
        dto.setMunicipio(amostra.getMunicipio());
        dto.setColetor(amostra.getColetor());
        dto.setEndereco(amostra.getEndereco());
        dto.setTipoAmostra(amostra.getTipoAmostra());
        dto.setStatus(amostra.getStatus());
        return dto;
    }

    public static Amostra toEntity(AmostraRequestDTO dto) {
        return new AmostraFlebotomineos(
            dto.getDataColeta(),
            dto.getHoraColeta(),
            dto.getMunicipio(),
            dto.getColetor(),
            dto.getEndereco(),
            dto.getTipoAmostra(),
            dto.getStatus()
        );
    }
    
}
