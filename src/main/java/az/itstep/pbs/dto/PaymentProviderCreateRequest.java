package az.itstep.pbs.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentProviderCreateRequest implements BaseDto {

    private String name;
    private BigDecimal commission;
}
