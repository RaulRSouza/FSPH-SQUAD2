// src/main/java/com/squad2/service/AmostraService.java
package com.squad2.service;

import com.squad2.model.Amostra;
import com.squad2.repository.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AmostraService {

    private final AmostraRepository amostraRepository;

    @Autowired
    public AmostraService(AmostraRepository amostraRepository) {
        this.amostraRepository = amostraRepository;
    }

    // Criar uma nova amostra
    public Amostra criarAmostra(Amostra amostra) {
        return amostraRepository.save(amostra);
    }

    // Buscar todas as amostras
    public List<Amostra> listarAmostras() {
        return amostraRepository.findAll();
    }

    // Buscar amostra por ID
    public Optional<Amostra> buscarPorId(Long id) {
        return amostraRepository.findById(id);
    }

    // src/main/java/com/squad2/service/AmostraService.java
public Amostra atualizarAmostra(Long id, Amostra amostraAtualizada) {
    return amostraRepository.findById(id)
        .map(amostra -> {
            // Atualiza todos os campos
            amostra.setTipoAmostra(amostraAtualizada.getTipoAmostra());
            amostra.setDataColeta(amostraAtualizada.getDataColeta());
            amostra.setHoraColeta(amostraAtualizada.getHoraColeta());
            amostra.setMunicipio(amostraAtualizada.getMunicipio());
            amostra.setColetor(amostraAtualizada.getColetor());
            amostra.setEndereco(amostraAtualizada.getEndereco());
            amostra.setTipoAmostra(amostraAtualizada.getTipoAmostra());
            amostra.setStatus(amostraAtualizada.getStatus());
            return amostraRepository.save(amostra);
        })
        .orElseThrow(() -> new RuntimeException("Amostra não encontrada"));
}

    // Deletar amostra
    public void deletarAmostra(Long id) {
        amostraRepository.deleteById(id);
    }
}