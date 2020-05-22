package com.cdm.gastos.repositories;

import com.cdm.gastos.models.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, String> {
}
