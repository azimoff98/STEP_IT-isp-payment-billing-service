package az.itstep.pbs.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "service")
@Data
public class ServiceType extends BaseEntity {

    private String serviceName;
    private BigDecimal price;
    private Double uploadSpeed;
    private Double downloadSpeed;
}
