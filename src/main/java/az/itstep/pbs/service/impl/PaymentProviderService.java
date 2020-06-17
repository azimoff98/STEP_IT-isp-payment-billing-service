package az.itstep.pbs.service.impl;

import az.itstep.pbs.entities.PaymentProvider;
import az.itstep.pbs.exception.NotFoundException;
import az.itstep.pbs.repository.PaymentProviderRepository;
import az.itstep.pbs.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProviderService implements BaseService<PaymentProvider> {

    private final PaymentProviderRepository paymentProviderRepository;

    @Override
    public PaymentProvider findById(Long id) {
        return paymentProviderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Payment provider found with id: " + id));
    }

    @Override
    public List<PaymentProvider> findAll() {
        return (List<PaymentProvider>) paymentProviderRepository.findAll();
    }

    @Override
    public void save(PaymentProvider paymentProvider) {
        paymentProvider.setCreationTime(LocalDateTime.now());
        paymentProviderRepository.save(paymentProvider);
    }

    @Override
    public void deleteById(Long id) {
        paymentProviderRepository.deleteById(id);
    }

    @Override
    public void update(PaymentProvider paymentProvider) {

    }
}
