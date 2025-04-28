package com.squad2.repository;

import com.squad2.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    Optional<Municipio> findByUsuario(String usuario);
}