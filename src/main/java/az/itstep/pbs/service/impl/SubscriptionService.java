package az.itstep.pbs.service.impl;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.dto.SubscriptionCreateRequest;
import az.itstep.pbs.entities.ServiceType;
import az.itstep.pbs.entities.Subscriber;
import az.itstep.pbs.entities.Subscription;
import az.itstep.pbs.exception.DomainUpdateException;
import az.itstep.pbs.exception.NotFoundException;
import az.itstep.pbs.mapper.SubscriptionCreateRequestMapper;
import az.itstep.pbs.repository.SubscriptionRepository;
import az.itstep.pbs.service.BaseService;
import az.itstep.pbs.util.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService implements BaseService<Subscription> {


    private final SubscriptionRepository subscriptionRepository;
    private final SubscriberService subscriberService;
    private final ServiceTypeService serviceTypeService;
    private final SubscriptionCreateRequestMapper subscriptionCreateRequestMapper;
    private final RandomGenerator randomGenerator;


    @Override
    public Subscription findById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No subscription found with id: "+id));
    }

    @Override
    public List<Subscription> findAll() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public void save(BaseDto baseDto) {
        SubscriptionCreateRequest subscriptionCreateRequest = (SubscriptionCreateRequest) baseDto;

        ServiceType serviceType = serviceTypeService.findById(subscriptionCreateRequest.getServiceTypeId());
        Subscriber subscriber = subscriberService.findById(subscriptionCreateRequest.getSubscriberId());

        Subscription subscription = subscriptionCreateRequestMapper.toEntity(subscriptionCreateRequest);

        subscription.setSubscriber(subscriber);
        subscription.setServiceType(serviceType);
        subscription.setSubscriptionNumber(randomGenerator.generateSubscriptionNumber());

        subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public Subscription update(Subscription subscription) {
        if(subscription.getId() == null)
            throw new DomainUpdateException("Please provide id");

        return subscriptionRepository.save(subscription);
    }
}
