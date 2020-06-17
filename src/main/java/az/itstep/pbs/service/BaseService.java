package az.itstep.pbs.service;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.entities.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T findById(Long id);
    List<T> findAll();
    void save(BaseDto baseDto);
    void deleteById(Long id);
    T update(T t);

}
