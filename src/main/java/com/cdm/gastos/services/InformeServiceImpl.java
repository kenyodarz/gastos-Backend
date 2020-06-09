package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.Informe;
import com.cdm.gastos.repositories.InformesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InformeServiceImpl extends GenericServiceImpl <Informe, Long> implements InformeServiceAPI {

    @Autowired
    private InformesRepository repository;

    @Override
    public CrudRepository<Informe, Long> getDAO() {
        return repository;
    }
}
