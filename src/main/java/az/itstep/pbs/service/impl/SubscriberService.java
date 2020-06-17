package az.itstep.pbs.service.impl;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.dto.SubscriberCreateRequest;
import az.itstep.pbs.entities.Subscriber;
import az.itstep.pbs.exception.DomainUpdateException;
import az.itstep.pbs.exception.NotFoundException;
import az.itstep.pbs.mapper.SubscriberCreateRequestMapper;
import az.itstep.pbs.repository.SubscriberRepository;
import az.itstep.pbs.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriberService implements BaseService<Subscriber> {

    private final SubscriberRepository subscriberRepository;
    private final SubscriberCreateRequestMapper subscriberCreateRequestMapper;
    @Override
    public Subscriber findById(Long id) {
        return subscriberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No subscriber found with id: " +id));
    }

    @Override
    public List<Subscriber> findAll() {
        return (List<Subscriber>) subscriberRepository.findAll();
    }

    @Override
    public void save(BaseDto request) {
        Subscriber subscriber = subscriberCreateRequestMapper.toEntity((SubscriberCreateRequest) request);
        subscriber.setCreationTime(LocalDateTime.now());
        subscriberRepository.save(subscriber);
    }

    @Override
    public void deleteById(Long id) {
        subscriberRepository.deleteById(id);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        if(subscriber.getId() == null)
            throw new DomainUpdateException("Please provide id");

        return subscriberRepository.save(subscriber);
    }
}
