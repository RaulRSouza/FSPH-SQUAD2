// src/main/java/com/squad2/service/EnvioAmostraService.java
package com.squad2.service;

import com.squad2.model.EnvioAmostra;
import com.squad2.repository.EnvioAmostraRepository;
import org.springframework.stereotype.Service;

@Service
public class EnvioAmostraService {

    private final EnvioAmostraRepository repository;
    private final ProtocoloGenerator protocoloGenerator;

    public EnvioAmostraService(EnvioAmostraRepository repository, ProtocoloGenerator protocoloGenerator) {
        this.repository = repository;
        this.protocoloGenerator = protocoloGenerator;
    }

    // Método renomeado para "criarEnvio" (corrige o erro no controller)
    public EnvioAmostra criarEnvio(EnvioAmostra envio, Long municipality) {
        String protocolo = protocoloGenerator.gerarProtocolo();
        envio.setProtocolo(protocolo);
        return repository.save(envio);
    }
}