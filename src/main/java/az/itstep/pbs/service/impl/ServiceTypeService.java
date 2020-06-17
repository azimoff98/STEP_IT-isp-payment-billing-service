package az.itstep.pbs.service.impl;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.dto.ServiceTypeCreateRequest;
import az.itstep.pbs.entities.ServiceType;
import az.itstep.pbs.exception.DomainUpdateException;
import az.itstep.pbs.exception.NotFoundException;
import az.itstep.pbs.mapper.ServiceTypeCreateRequestMapper;
import az.itstep.pbs.repository.ServiceTypeRepository;
import az.itstep.pbs.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceTypeService implements BaseService<ServiceType> {

    private final ServiceTypeRepository serviceTypeRepository;
    private final ServiceTypeCreateRequestMapper serviceTypeCreateRequestMapper;

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No service type found for id: "+id));
    }

    @Override
    public List<ServiceType> findAll() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @Override
    public void save(BaseDto baseDto) {
        ServiceType serviceType = serviceTypeCreateRequestMapper.toEntity((ServiceTypeCreateRequest) baseDto);
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void deleteById(Long id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public ServiceType update(ServiceType serviceType) {
        if(serviceType.getId() == null)
            throw new DomainUpdateException("Please provide id");

        return serviceTypeRepository.save(serviceType);
    }
}
