
package com.squad2.controller;

import com.squad2.model.EnvioAmostra;
import com.squad2.model.Municipio;
import com.squad2.service.EnvioAmostraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
public class EnvioAmostraController {

    private final EnvioAmostraService service;

    public EnvioAmostraController(EnvioAmostraService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cadastrar envio de amostra", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<EnvioAmostra> criarEnvio(
            @RequestBody EnvioAmostra envio,
            @AuthenticationPrincipal Municipio municipio) {
        EnvioAmostra novoEnvio = service.criarEnvio(envio, municipio.getId());
        return ResponseEntity.ok(novoEnvio);
    }
}