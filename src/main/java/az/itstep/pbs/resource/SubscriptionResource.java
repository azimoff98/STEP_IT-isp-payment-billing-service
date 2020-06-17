package az.itstep.pbs.resource;

import az.itstep.pbs.dto.SubscriptionCreateRequest;
import az.itstep.pbs.entities.Subscription;
import az.itstep.pbs.service.impl.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
@Slf4j
public class SubscriptionResource {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubscriptionCreateRequest request){
        subscriptionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Service type created");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable Long id){
        Subscription response = subscriptionService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> findAll(){
        List<Subscription> response = subscriptionService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        subscriptionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Service Type deleted successfully");
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Subscription subscription){
        Subscription response = subscriptionService.update(subscription);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    
    
}
