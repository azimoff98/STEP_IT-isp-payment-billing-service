package az.itstep.pbs.repository;

import az.itstep.pbs.entities.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    @Query("select s from Subscription s where s.subscriptionNumber = :subscriptionNumber")
    Optional<Subscription> findBySubscriptionNumber(@Param(value = "subscriptionNumber") String subscriptionNumber);
    @Query("select s from Subscription s where s.scheduledBlockingDate < :end and s.scheduledBlockingDate > :start")
    List<Subscription> findAllExpired(@Param(value = "end") LocalDateTime end, @Param("start") LocalDateTime start);
}
