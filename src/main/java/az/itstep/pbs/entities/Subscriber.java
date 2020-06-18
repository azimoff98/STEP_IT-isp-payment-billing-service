package az.itstep.pbs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @OneToMany(mappedBy = "subscriber", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subscription> subscriptions;
}
