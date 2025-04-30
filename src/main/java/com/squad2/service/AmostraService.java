package com.squad2.service;

import com.squad2.dto.AmostraRequestDTO;
import com.squad2.dto.AmostraResponseDTO;
import com.squad2.mapper.AmostraMapper;
import com.squad2.model.Amostra;
import com.squad2.repository.AmostraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmostraService {

    private final AmostraRepository amostraRepository;

    public AmostraService(AmostraRepository amostraRepository) {
        this.amostraRepository = amostraRepository;
    }

    public AmostraResponseDTO criarAmostra(AmostraRequestDTO dto) {
        Amostra amostra = AmostraMapper.toEntity(dto);
        Amostra salva = amostraRepository.save(amostra);
        return AmostraMapper.toResponseDTO(salva);
    }

    public List<AmostraResponseDTO> listarAmostras() {
        return amostraRepository.findAll()
                .stream()
                .map(AmostraMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<AmostraResponseDTO> buscarPorId(Long id) {
        return amostraRepository.findById(id)
                .map(AmostraMapper::toResponseDTO);
    }

    public AmostraResponseDTO atualizarAmostra(Long id, AmostraRequestDTO dto) {
        return amostraRepository.findById(id)
                .map(existing -> {
                    existing.setDataColeta(dto.getDataColeta());
                    existing.setHoraColeta(dto.getHoraColeta());
                    existing.setMunicipio(dto.getMunicipio());
                    existing.setColetor(dto.getColetor());
                    existing.setEndereco(dto.getEndereco());
                    existing.setTipoAmostra(dto.getTipoAmostra());
                    existing.setStatus(dto.getStatus());
                    return AmostraMapper.toResponseDTO(amostraRepository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Amostra não encontrada com ID: " + id));
    }

    public void deletarAmostra(Long id) {
        amostraRepository.deleteById(id);
    }
}
