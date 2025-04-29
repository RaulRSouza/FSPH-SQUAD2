// src/main/java/com/squad2/service/AmostraService.java
package com.squad2.service;

import com.squad2.dtos.AmostraDto;
import com.squad2.model.Amostra;
import com.squad2.model.Status;
import com.squad2.model.TipoAmostra;
import com.squad2.repository.AmostraRepository;
import com.squad2.repository.StatusRepository;
import com.squad2.repository.TipoAmostraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AmostraService {

    private final AmostraRepository amostraRepository;
    private final TipoAmostraRepository tipoAmostraRepository;
    private final StatusRepository statusRepository;

    public AmostraService(AmostraRepository amostraRepository, TipoAmostraRepository tipoAmostraRepository, StatusRepository statusRepository) {
        this.amostraRepository = amostraRepository;
        this.tipoAmostraRepository = tipoAmostraRepository;
        this.statusRepository = statusRepository;
    }

    // Criar uma nova amostra
    @Transactional
    public void criarAmostra(AmostraDto amostra) {
        TipoAmostra tipoAmostra = tipoAmostraRepository.findById(amostra.tipoAmostra().getId())
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));

        Status status = statusRepository.findById(amostra.status().getId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        Amostra novaAmostra = new Amostra(amostra, tipoAmostra, status);
        amostraRepository.save(novaAmostra);
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