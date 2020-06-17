package az.itstep.pbs.service.impl;

import az.itstep.pbs.entities.Subscriber;
import az.itstep.pbs.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements BaseService<Subscriber> {

    @Override
    public Subscriber findById(Long id) {
        return null;
    }

    @Override
    public List<Subscriber> findAll() {
        return null;
    }

    @Override
    public void save(Subscriber subscriber) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Subscriber subscriber) {

    }
}
