package az.itstep.pbs.service.impl;

import az.itstep.pbs.dto.BaseDto;
import az.itstep.pbs.dto.PaymentRequest;
import az.itstep.pbs.entities.Payment;
import az.itstep.pbs.entities.PaymentProvider;
import az.itstep.pbs.entities.Subscription;
import az.itstep.pbs.exception.NotFoundException;
import az.itstep.pbs.mapper.PaymentRequestMapper;
import az.itstep.pbs.repository.PaymentProviderRepository;
import az.itstep.pbs.repository.PaymentRepository;
import az.itstep.pbs.service.BaseService;
import az.itstep.pbs.util.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService implements BaseService<Payment> {


    private final PaymentRepository paymentRepository;
    private final PaymentProviderRepository paymentProviderRepository;
    private final SubscriptionService subscriptionService;
    private final PaymentRequestMapper paymentRequestMapper;
    private final RandomGenerator randomGenerator;

    // TODO: 18/06/2020 Add payment commission
    public Payment pay(PaymentRequest paymentRequest){
      log.info("Processing payment for subscription : {} with amount : {}", paymentRequest.getSubscriptionNumber(), paymentRequest.getAmount());

      Payment payment = paymentRequestMapper.toEntity(paymentRequest);
      payment.setRrn(randomGenerator.generateRrn());
      PaymentProvider paymentProvider = paymentProviderRepository.findById(paymentRequest.getPaymentProviderId())
              .orElseThrow(() -> new NotFoundException("No Provider Found with id: "+paymentRequest.getPaymentProviderId()));
      payment.setPaymentProvider(paymentProvider);

      subscriptionService.debit(paymentRequest.getSubscriptionNumber(), paymentRequest.getAmount());
      return paymentRepository.save(payment);

    }

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
