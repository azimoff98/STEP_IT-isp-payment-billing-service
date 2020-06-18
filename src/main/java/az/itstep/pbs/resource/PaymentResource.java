package az.itstep.pbs.resource;

import az.itstep.pbs.dto.PaymentRequest;
import az.itstep.pbs.entities.Payment;
import az.itstep.pbs.service.impl.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {


    private final PaymentService paymentService;


    @PostMapping
    public ResponseEntity<?> pay(@RequestBody PaymentRequest request) {
        log.info("Incoming payment for subscription: {} with amount {}", request.getSubscriptionNumber(), request.getAmount());
        Payment response = paymentService.pay(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}
