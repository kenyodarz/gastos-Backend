package com.cdm.gastos.services;

import com.cdm.gastos.core.utils.GenericServiceImpl;
import com.cdm.gastos.models.User;
import com.cdm.gastos.repositories.UserDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl <User, Long> implements UserServiceAPI {

    @Autowired
    UserDaoAPI userDaoAPI;

    @Override
    public CrudRepository<User, Long> getDAO() {
        return userDaoAPI;
    }
}
