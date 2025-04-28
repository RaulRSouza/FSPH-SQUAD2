// src/main/java/com/squad2/repository/TipoAmostraRepository.java
package com.squad2.repository;

import com.squad2.model.TipoAmostra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAmostraRepository extends JpaRepository<TipoAmostra, Long> {
    // Métodos personalizados podem ser adicionados aqui
}