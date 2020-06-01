package com.cdm.gastos.repositories;

import com.cdm.gastos.models.RegistroSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroSalidaRepository extends JpaRepository <RegistroSalida, Long> {
}
