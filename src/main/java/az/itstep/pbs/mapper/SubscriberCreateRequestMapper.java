package az.itstep.pbs.mapper;

import az.itstep.pbs.dto.SubscriberCreateRequest;
import az.itstep.pbs.entities.Subscriber;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SubscriberCreateRequestMapper implements BaseMapper<SubscriberCreateRequest, Subscriber> {

    @Override
    public Subscriber toEntity(SubscriberCreateRequest request) {
        Subscriber subscriber = Subscriber.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .finCode(request.getFinCode())
                .passportNumber(request.getPassportNumber())
                .phoneNumber(request.getPhoneNumber())
                .build();
        subscriber.setCreationTime(LocalDateTime.now());
        return subscriber;
    }

    @Override
    public SubscriberCreateRequest toDto(Subscriber subscriber) {
        return null;
    }
}
