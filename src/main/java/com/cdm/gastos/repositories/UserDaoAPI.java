package com.cdm.gastos.repositories;

import com.cdm.gastos.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoAPI  extends CrudRepository <User, Long>
{
}
