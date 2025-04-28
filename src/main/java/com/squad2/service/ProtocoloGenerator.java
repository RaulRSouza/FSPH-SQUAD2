// src/main/java/com/squad2/service/ProtocoloGenerator.java
package com.squad2.service;

import com.squad2.model.ProtocoloSequence;
import com.squad2.repository.RepositoryProtocoloSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ProtocoloGenerator {

    @Autowired
    private RepositoryProtocoloSequence repositoryProtocoloSequence;

    public String gerarProtocolo() {
        String sequenceId = "protocolo-" + LocalDate.now().getYear(); // Ex: "protocolo-2023"
        ProtocoloSequence sequencia = repositoryProtocoloSequence.buscarOuCriarSequencia(sequenceId);
        sequencia.setValor(sequencia.getValor() + 1); // Incrementa
        repositoryProtocoloSequence.save(sequencia); // Salva a atualização
        return "PROTOCOLO-" + sequencia.getValor();
    }
}