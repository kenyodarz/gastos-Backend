package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.Saldo;
import com.cdm.gastos.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoServiceImpl extends GenericServiceImpl <Saldo, Long> implements SaldoServiceAPI {

    @Autowired
    SaldoRepository repository;

    @Override
    public CrudRepository<Saldo, Long> getDAO() {
        return repository;
    }
}
