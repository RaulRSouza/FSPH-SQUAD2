package com.squad2.repository;

import com.squad2.model.EnvioAmostra;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnvioAmostraRepository extends JpaRepository<EnvioAmostra, Long> {
    List<EnvioAmostra> findByMunicipioResponsavelId(Long municipioId);
}