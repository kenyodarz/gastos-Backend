package com.cdm.gastos.core.utils;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI <T, ID extends Serializable>{

    T save (T entity);

    void delete (ID id);

    T get(ID id);

    List<T> getAll();

    CrudRepository <T, ID> getDAO();
}
