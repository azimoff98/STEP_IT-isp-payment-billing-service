package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.SubscriptionCreateRequest;
import az.itstep.pbs.entities.Subscription;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class SubscriptionCreateRequestMapper implements BaseMapper<SubscriptionCreateRequest, Subscription> {


    @Override
    public SubscriptionCreateRequest toDto(Subscription subscription) {
        return null;
    }

    @Override
    public Subscription toEntity(SubscriptionCreateRequest request) {
        Subscription subscription = Subscription.builder()
                .address(request.getAddress())
                .balance(new BigDecimal("0.00"))
                .build();

        subscription.setCreationTime(LocalDateTime.now());
        return subscription;
    }
}
