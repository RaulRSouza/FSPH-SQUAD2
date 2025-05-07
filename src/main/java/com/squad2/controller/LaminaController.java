package com.squad2.controller;

import com.squad2.dtos.EditarLaminaDto;
import com.squad2.model.Lamina;
import com.squad2.service.LaminaService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/laminas")
public class LaminaController {

    private final LaminaService laminaService;

    public LaminaController(LaminaService laminaService) {
        this.laminaService = laminaService;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirLamina(@PathVariable Long id){
        laminaService.excluirLamina(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Lamina> editarLamina(@RequestBody EditarLaminaDto dados){
        var lamina = laminaService.carregarLamina(dados.id());
        lamina.editarLamina(dados);

        return ResponseEntity.ok(lamina);
    }
}
