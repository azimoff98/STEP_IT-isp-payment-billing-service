package az.itstep.pbs.repository;

import az.itstep.pbs.entities.PaymentProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentProviderRepository extends CrudRepository<PaymentProvider, Long> {
}
