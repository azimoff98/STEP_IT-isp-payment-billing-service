package az.itstep.pbs.service.impl;

import az.itstep.pbs.entities.ServiceType;
import az.itstep.pbs.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements BaseService<ServiceType> {

    @Override
    public ServiceType findById(Long id) {
        return null;
    }

    @Override
    public List<ServiceType> findAll() {
        return null;
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(ServiceType serviceType) {

    }
}
