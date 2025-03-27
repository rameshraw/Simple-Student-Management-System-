package com.ramesh.dao.repository;

import java.util.List;

public interface CrudInterface<T>{
    void save(T t);
    List<T> getall();
    void update(int id,T t);
    void delete(int id );


}
