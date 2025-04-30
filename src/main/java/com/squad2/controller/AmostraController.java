package com.squad2.controller;

import com.squad2.dto.AmostraRequestDTO;
import com.squad2.dto.AmostraResponseDTO;
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

    public AmostraController(AmostraService amostraService) {
        this.amostraService = amostraService;
    }

    @PostMapping
    @Operation(
        summary = "Criar nova amostra",
        tags = {"POST - Criar amostra"},
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<?> criarAmostra(@RequestBody AmostraRequestDTO dto) {
        try {
            AmostraResponseDTO novaAmostra = amostraService.criarAmostra(dto);
            return ResponseEntity.ok(novaAmostra);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @Operation(
        summary = "Listar todas as amostras",
        tags = {"GET - Listar amostras"}
    )
    public ResponseEntity<List<AmostraResponseDTO>> listarAmostras() {
        return ResponseEntity.ok(amostraService.listarAmostras());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar amostra por ID",
        tags = {"GET - Buscar amostra por ID"}
    )
    public ResponseEntity<AmostraResponseDTO> buscarPorId(@PathVariable Long id) {
        return amostraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar amostra",
        tags = {"PUT - Atualizar amostra"},
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<AmostraResponseDTO> atualizarAmostra(
            @PathVariable Long id,
            @RequestBody AmostraRequestDTO dto) {
        AmostraResponseDTO amostraAtualizada = amostraService.atualizarAmostra(id, dto);
        return ResponseEntity.ok(amostraAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Deletar amostra",
        tags = {"DELETE - Deletar amostra"},
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<Void> deletarAmostra(@PathVariable Long id) {
        amostraService.deletarAmostra(id);
        return ResponseEntity.noContent().build();
    }
}
