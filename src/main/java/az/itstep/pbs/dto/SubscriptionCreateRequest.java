package az.itstep.pbs.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SubscriptionCreateRequest implements BaseDto{

    private String address;
    @NotNull
    @Min(1)
    private Long subscriberId;
    @NotNull
    @Min(1)
    private Long serviceTypeId;
}
