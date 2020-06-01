package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.RegistroSalida;
import com.cdm.gastos.repositories.RegistroSalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroSalidaServiceImpl extends GenericServiceImpl <RegistroSalida, Long> implements RegistroSalidaServiceAPI {

    @Autowired
    RegistroSalidaRepository repository;

    @Override
    public CrudRepository<RegistroSalida, Long> getDAO() {
        return repository;
    }
}
