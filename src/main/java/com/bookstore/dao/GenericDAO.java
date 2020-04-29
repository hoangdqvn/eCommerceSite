package com.bookstore.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDAO<ID extends Serializable, T>  {
    List<T> findAll();

    T update(T entity);

    T save(T entity);

    T findByID(ID id);

    Object[] findByProperty(Map<String, Object> property, Boolean exact, String whereClause);

    Integer delete(List<ID> ids);

//    T findEqualUnique(String property, Object value);
}
