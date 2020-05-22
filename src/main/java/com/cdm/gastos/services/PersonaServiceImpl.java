package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.Persona;
import com.cdm.gastos.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, String>  implements  PersonaServiceAPI{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, String> getDAO() {
        return personaRepository;
    }
}
