package pe.edu.upc.procv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.procv.model.Advisory;
import pe.edu.upc.procv.service.AdvisoryService;

import java.util.List;

@RestController
@RequestMapping("/advisories")
public class AdvisoryController {

    @Autowired
    private AdvisoryService advisoryService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            List<Advisory> advisories = advisoryService.findAll();
            return ResponseEntity.ok(advisories);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping("/{idAdvisory}")
    public ResponseEntity<?> listById(@PathVariable int idAdvisory) {
        try {
            Advisory advisory = advisoryService.findById(idAdvisory);
            return ResponseEntity.ok(advisory);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Advisory advisory) {
        try {
        Advisory advisorySave = advisoryService.create(advisory);
        return ResponseEntity.ok(advisorySave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PutMapping("/{idAdvisory}")
    public ResponseEntity<?> update(@PathVariable int idAdvisory, @RequestBody Advisory advisory) {
        try {
            advisory.setIdAdvisory(idAdvisory);
            Advisory advisorySave = advisoryService.update(advisory);
            return ResponseEntity.ok(advisorySave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("/{idAdvisory}")
    public ResponseEntity<?> deleteById(@PathVariable int idAdvisory) {
        try {
        advisoryService.deleteById(idAdvisory);
        return ResponseEntity.ok(null);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
