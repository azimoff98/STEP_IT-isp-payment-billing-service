package az.itstep.pbs.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType extends BaseEntity {

    private String serviceName;
    private BigDecimal price;
    private Double uploadSpeed;
    private Double downloadSpeed;
}
