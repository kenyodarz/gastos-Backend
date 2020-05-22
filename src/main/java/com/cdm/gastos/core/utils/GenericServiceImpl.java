package com.cdm.gastos.core.utils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public T save(T entity) {
        return getDAO().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDAO().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> optUser = getDAO().findById(id); // returns java8 optional
        // handle not found, return null or throw
        return optUser.orElse(null);


    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getDAO ().findAll().forEach(returnList::add);
        return returnList;
    }


    public abstract CrudRepository <T, ID> getDAO();


}