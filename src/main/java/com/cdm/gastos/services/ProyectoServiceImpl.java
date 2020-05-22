package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.Proyecto;
import com.cdm.gastos.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProyectoServiceImpl extends GenericServiceImpl <Proyecto, String> implements ProyectoServiceApi {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public CrudRepository<Proyecto, String> getDAO() {
        return proyectoRepository;
    }
}
