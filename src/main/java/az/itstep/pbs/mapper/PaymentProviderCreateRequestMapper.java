package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.PaymentProviderCreateRequest;
import az.itstep.pbs.entities.PaymentProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentProviderCreateRequestMapper implements BaseMapper<PaymentProviderCreateRequest, PaymentProvider> {

    @Override
    public PaymentProviderCreateRequest toDto(PaymentProvider paymentProvider) {
        return null;
    }

    @Override
    public PaymentProvider toEntity(PaymentProviderCreateRequest request) {
        PaymentProvider paymentProvider = PaymentProvider.builder()
                .name(request.getName())
                .commission(request.getCommission())
                .build();
        paymentProvider.setCreationTime(LocalDateTime.now());
        return paymentProvider;
    }
}
