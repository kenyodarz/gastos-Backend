package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.Description;
import com.cdm.gastos.repositories.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DescriptionServiceImpl extends GenericServiceImpl <Description,Long> implements DescriptionServiceAPI {

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    public CrudRepository<Description, Long> getDAO() {
        return descriptionRepository;
    }
}
