package az.itstep.pbs.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseEntity{

    @Column(unique = true)
    private String rrn;
    private BigDecimal amount;
    @OneToOne(cascade = CascadeType.DETACH)
    private PaymentProvider paymentProvider;

}
