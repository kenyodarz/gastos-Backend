package com.cdm.gastos.repositories;

import com.cdm.gastos.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends JpaRepository <Saldo, Long> {

}
