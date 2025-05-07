package com.squad2.service;

import com.squad2.model.Lamina;
import com.squad2.repository.LaminaRepository;
import org.springframework.stereotype.Service;

@Service
public class LaminaService {

    private final LaminaRepository laminaRepository;

    public LaminaService(LaminaRepository laminaRepository) {
        this.laminaRepository = laminaRepository;
    }

    public void excluirLamina(Long id){
        laminaRepository.deleteById(id);
    }

    public Lamina carregarLamina(Long id){
        return laminaRepository.getReferenceById(id);
    }
}
