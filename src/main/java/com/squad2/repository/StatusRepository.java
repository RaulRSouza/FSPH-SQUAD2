// src/main/java/com/squad2/repository/StatusRepository.java
package com.squad2.repository;

import com.squad2.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    // Métodos personalizados podem ser adicionados aqui
}