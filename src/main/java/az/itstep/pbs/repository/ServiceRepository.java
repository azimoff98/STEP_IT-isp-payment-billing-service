package az.itstep.pbs.repository;

import az.itstep.pbs.entities.ServiceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceType, Long> {
}
