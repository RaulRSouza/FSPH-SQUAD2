// src/main/java/com/squad2/repository/AmostraRepository.java
package com.squad2.repository;

import com.squad2.model.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmostraRepository extends JpaRepository<Amostra, Long> {
    // Métodos personalizados (ex: buscar amostras por envio)
    // List<Amostra> findByEnvioAmostraId(Long envioId);
}