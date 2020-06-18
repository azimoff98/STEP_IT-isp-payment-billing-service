package az.itstep.pbs.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest implements BaseDto{

    private String subscriptionNumber;
    private BigDecimal amount;
    private Long paymentProviderId;
}
