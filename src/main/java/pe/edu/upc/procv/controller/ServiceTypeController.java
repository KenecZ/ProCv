package pe.edu.upc.procv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.procv.model.ServiceType;
import pe.edu.upc.procv.service.ServiceTypeService;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/serviceTypes")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            List<ServiceType> serviceTypes = serviceTypeService.findAll();
            return ResponseEntity.ok(serviceTypes);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping("/{idServiceType}")
    public ResponseEntity<?> listById(@PathVariable int idServiceType) {
        try {
            ServiceType serviceType = serviceTypeService.findById(idServiceType);
            return ResponseEntity.ok(serviceType);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServiceType serviceType) {
        try {
        ServiceType serviceTypeSave = serviceTypeService.create(serviceType);
        return ResponseEntity.ok(serviceTypeSave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PutMapping("/{idServiceType}")
    public ResponseEntity<?> update(@PathVariable int idServiceType, @RequestBody ServiceType serviceType) {
        try {
            serviceType.setIdServiceType(idServiceType);
            ServiceType serviceTypeSave = serviceTypeService.update(serviceType);
            return ResponseEntity.ok(serviceTypeSave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("/{idServiceType}")
    public ResponseEntity<?> deleteById(@PathVariable int idServiceType) {
        try {
        serviceTypeService.deleteById(idServiceType);
        return ResponseEntity.ok(null);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
