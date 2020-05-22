package com.cdm.gastos.repositories;

import com.cdm.gastos.models.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, String> {
}
