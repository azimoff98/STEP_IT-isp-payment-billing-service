package az.itstep.pbs.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceTypeCreateRequest implements BaseDto {
    private String serviceName;
    private BigDecimal price;
    private Double uploadSpeed;
    private Double downloadSpeed;
}
