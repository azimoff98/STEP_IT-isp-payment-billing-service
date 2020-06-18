package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.PaymentRequest;
import az.itstep.pbs.entities.Payment;
import az.itstep.pbs.entities.PaymentProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentRequestMapper implements BaseMapper<PaymentRequest, Payment> {

    @Override
    public PaymentRequest toDto(Payment payment) {
        return null;
    }

    @Override
    public Payment toEntity(PaymentRequest paymentRequest) {
        Payment payment = Payment.builder()
                .amount(paymentRequest.getAmount())
                .build();
        payment.setCreationTime(LocalDateTime.now());
        return payment;
    }
}
