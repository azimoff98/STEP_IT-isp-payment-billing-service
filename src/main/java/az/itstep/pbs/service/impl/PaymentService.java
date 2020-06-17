package az.itstep.pbs.service.impl;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.entities.Payment;
import az.itstep.pbs.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements BaseService<Payment> {

    @Override
    public Payment findById(Long id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public void save(BaseDto baseDto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }
}
