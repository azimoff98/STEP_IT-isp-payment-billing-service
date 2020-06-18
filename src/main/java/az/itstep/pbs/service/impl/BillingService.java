package az.itstep.pbs.service.impl;

import az.itstep.pbs.entities.Subscription;
import az.itstep.pbs.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingService {


    private final SubscriptionService subscriptionService;
    private final SubscriptionRepository subscriptionRepository;


    @Scheduled(cron = "0 14 21 * * *")
    public void bill(){
        LocalDateTime to = LocalDate.now().atStartOfDay().plusDays(1);
        LocalDateTime from = LocalDate.now().atStartOfDay();
        log.info("Fetching subscriptions with expire date from: {} to: {}",from, to);
        List<Subscription> subscriptions = subscriptionRepository.findAllExpired(to, from);
        subscriptions.forEach(s -> {
            log.info("Performing credit to subscription with number: {}", s.getSubscriptionNumber());
            subscriptionService.credit(s);
        });
    }

}
