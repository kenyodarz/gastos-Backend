package com.cdm.gastos.repositories;

import com.cdm.gastos.models.RegistroEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository  extends JpaRepository<RegistroEntrada,Long> {
}
