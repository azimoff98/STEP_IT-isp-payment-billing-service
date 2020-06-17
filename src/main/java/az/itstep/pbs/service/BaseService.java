package az.itstep.pbs.service;

import az.itstep.pbs.entities.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T findById(Long id);
    List<T> findAll();
    void save(T t);
    void deleteById(Long id);
    void update(T t);

}
