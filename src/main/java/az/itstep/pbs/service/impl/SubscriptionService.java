package az.itstep.pbs.service.impl;

import az.itstep.pbs.entities.Subscription;
import az.itstep.pbs.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements BaseService<Subscription> {




    @Override
    public Subscription findById(Long id) {
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        return null;
    }

    @Override
    public void save(Subscription subscription) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Subscription subscription) {

    }
}
