// src/main/java/com/squad2/repository/RepositoryProtocoloSequence.java
package com.squad2.repository;

import com.squad2.model.ProtocoloSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryProtocoloSequence extends JpaRepository<ProtocoloSequence, String> {
    
    default ProtocoloSequence buscarOuCriarSequencia(String id) {
        Optional<ProtocoloSequence> sequenciaOptional = findById(id);
        if (sequenciaOptional.isPresent()) {
            return sequenciaOptional.get();
        } else {
            ProtocoloSequence novaSequencia = new ProtocoloSequence();
            novaSequencia.setId(id);
            novaSequencia.setValor(0L);
            return save(novaSequencia);
        }
    }
}