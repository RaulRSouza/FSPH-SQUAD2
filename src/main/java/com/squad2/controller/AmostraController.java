// src/main/java/com/squad2/controller/AmostraController.java
package com.squad2.controller;

import com.squad2.model.Amostra;
import com.squad2.model.Status;
import com.squad2.model.TipoAmostra;
import com.squad2.repository.StatusRepository;
import com.squad2.repository.TipoAmostraRepository;
import com.squad2.service.AmostraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amostras")
public class AmostraController {

    private final AmostraService amostraService;
    private final TipoAmostraRepository tipoAmostraRepository;
    private final StatusRepository statusRepository;

    public AmostraController(
        AmostraService amostraService,
        TipoAmostraRepository tipoAmostraRepository,
        StatusRepository statusRepository
    ) {
        this.amostraService = amostraService;
        this.tipoAmostraRepository = tipoAmostraRepository;
        this.statusRepository = statusRepository;
    }

    @PostMapping
    @Operation(summary = "Criar nova amostra", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> criarAmostra(@RequestBody Amostra amostra) {
        try {
            // Validação do Tipo de Amostra
            TipoAmostra tipoAmostra = tipoAmostraRepository
                .findById(amostra.getTipoAmostra().getId())
                .orElseThrow(() -> new RuntimeException("Tipo de amostra não encontrado"));

            // Validação do Status
            Status status = statusRepository
                .findById(amostra.getStatus().getId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

            // Atualiza os relacionamentos
            amostra.setTipoAmostra(tipoAmostra);
            amostra.setStatus(status);

            Amostra novaAmostra = amostraService.criarAmostra(amostra);
            return ResponseEntity.ok(novaAmostra);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Listar todas as amostras")
    public ResponseEntity<List<Amostra>> listarAmostras() {
        List<Amostra> amostras = amostraService.listarAmostras();
        return ResponseEntity.ok(amostras);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar amostra por ID")
    public ResponseEntity<Amostra> buscarPorId(@PathVariable Long id) {
        return amostraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar amostra", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Amostra> atualizarAmostra(
            @PathVariable Long id,
            @RequestBody Amostra amostra) {
        Amostra amostraAtualizada = amostraService.atualizarAmostra(id, amostra);
        return ResponseEntity.ok(amostraAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar amostra", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> deletarAmostra(@PathVariable Long id) {
        amostraService.deletarAmostra(id);
        return ResponseEntity.noContent().build();
    }
}