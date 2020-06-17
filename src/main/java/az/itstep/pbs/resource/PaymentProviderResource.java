package az.itstep.pbs.resource;

import az.itstep.pbs.dto.PaymentProviderCreateRequest;
import az.itstep.pbs.entities.PaymentProvider;
import az.itstep.pbs.service.impl.PaymentProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-providers")
@RequiredArgsConstructor
@Slf4j
public class PaymentProviderResource {

    private final PaymentProviderService paymentProviderService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PaymentProviderCreateRequest request){
        paymentProviderService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Payment provider created");
    }

    @GetMapping
    public ResponseEntity<List<PaymentProvider>> findAll(){
        List<PaymentProvider> response = paymentProviderService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentProvider> findById(@PathVariable Long id){
        PaymentProvider response = paymentProviderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        paymentProviderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Provider deleted successfully");
    }
}

