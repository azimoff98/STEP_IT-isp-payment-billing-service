package az.itstep.pbs.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Subscriber extends BaseEntity{

    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String surname;
    @Column(length = 20, nullable = false)
    private String passportNumber;
    @Column(length = 15, nullable = false)
    private String finCode;
    private String address;
    @Column(length = 13 ,nullable = false)
    private String phoneNumber;
    @OneToMany(mappedBy = "subscriber")
    private List<Subscription> subscriptions;
}
