package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.RegistroEntrada;
import com.cdm.gastos.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImp extends GenericServiceImpl <RegistroEntrada, Long> implements RegistroServiceAPI {

    @Autowired
    RegistroRepository repository;

    @Override
    public CrudRepository<RegistroEntrada, Long> getDAO() {
        return repository;
    }
}
