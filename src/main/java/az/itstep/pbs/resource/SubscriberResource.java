package az.itstep.pbs.resource;

import az.itstep.pbs.dto.SubscriberCreateRequest;
import az.itstep.pbs.entities.ServiceType;
import az.itstep.pbs.entities.Subscriber;
import az.itstep.pbs.service.impl.SubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
@Slf4j
public class SubscriberResource {
    
    private final SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubscriberCreateRequest request){
        subscriberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Subscriber created");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> findById(@PathVariable Long id){
        Subscriber response = subscriberService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<Subscriber>> findAll(){
        List<Subscriber> response = subscriberService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        subscriberService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Service Type deleted successfully");
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Subscriber subscriber){
        Subscriber response = subscriberService.update(subscriber);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
