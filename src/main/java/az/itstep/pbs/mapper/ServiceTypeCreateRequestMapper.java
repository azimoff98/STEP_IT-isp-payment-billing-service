package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.ServiceTypeCreateRequest;
import az.itstep.pbs.entities.ServiceType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ServiceTypeCreateRequestMapper implements BaseMapper<ServiceTypeCreateRequest, ServiceType> {


    @Override
    public ServiceTypeCreateRequest toDto(ServiceType serviceType) {
        return null;
    }

    @Override
    public ServiceType toEntity(ServiceTypeCreateRequest request) {
        ServiceType serviceType = ServiceType.builder()
                .serviceName(request.getServiceName())
                .price(request.getPrice())
                .downloadSpeed(request.getDownloadSpeed())
                .uploadSpeed(request.getUploadSpeed())
                .build();
        serviceType.setCreationTime(LocalDateTime.now());
        return serviceType;
    }
}
