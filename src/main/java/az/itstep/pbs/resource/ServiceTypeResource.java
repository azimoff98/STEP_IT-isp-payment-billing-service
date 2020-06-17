package az.itstep.pbs.resource;

import az.itstep.pbs.entities.ServiceType;
import az.itstep.pbs.service.impl.ServiceTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@Slf4j
public class ServiceTypeResource {

    private final ServiceTypeService serviceTypeService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ServiceType serviceType){
        serviceTypeService.save(serviceType);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Service type created");
    }


    @GetMapping("/{id}")
    public ResponseEntity<ServiceType> findById(@PathVariable Long id){
        ServiceType response = serviceTypeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ServiceType>> findAll(){
        List<ServiceType> response = serviceTypeService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
