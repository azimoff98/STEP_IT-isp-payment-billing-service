package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.entities.BaseEntity;

/**
 *
 * @param <D> stands for Data transfer Object
 * @param <E> stands for Entity
 */
public interface BaseMapper<D extends BaseDto, E extends BaseEntity> {

    D toDto(E e);
    E toEntity(D d);

}
