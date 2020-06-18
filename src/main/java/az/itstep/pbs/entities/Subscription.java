package az.itstep.pbs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String subscriptionNumber;
    @Column(nullable = false)
    private BigDecimal balance;
    private LocalDateTime lastPaymentDate;
    private LocalDateTime lastChargingDate;
    private LocalDateTime scheduledBlockingDate;
    private String address;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    @JsonIgnore
    @ToString.Exclude
    private Subscriber subscriber;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceType serviceType;

}
