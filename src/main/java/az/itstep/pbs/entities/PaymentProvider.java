package az.itstep.pbs.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class PaymentProvider extends BaseEntity{

    private String name;
    private BigDecimal commission;
}
