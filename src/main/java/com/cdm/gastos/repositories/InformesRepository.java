package com.cdm.gastos.repositories;

import com.cdm.gastos.models.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformesRepository extends JpaRepository <Informe,Long> {
}
