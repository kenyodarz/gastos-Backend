package com.cdm.gastos.repositories;

import com.cdm.gastos.models.Description;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends CrudRepository <Description, Long> {
}
