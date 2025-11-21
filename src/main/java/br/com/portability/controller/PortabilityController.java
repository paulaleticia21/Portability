package br.com.portability.controller;

import br.com.portability.domain.Portability;
import br.com.portability.service.PortabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/credit-portability")
public class PortabilityController {

    @Autowired
    private PortabilityService service;


    @GetMapping("portabilities")
    public List<Portability> findAll() {
        return service.findAll();
    }

    @GetMapping("portabilities/{portabilityId}")
    public Optional<Portability> findById(@PathVariable String portabilityId) {
        return service.findById(portabilityId);
    }

    @PostMapping
    public ResponseEntity<Portability> save(@RequestBody Portability portability) {
        Portability saved = service.save(portability);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("portabilities/{portabilityId}/cancel")
    public ResponseEntity<Void> delete(@PathVariable String portabilityId) {
        service.delete(portabilityId);
        return ResponseEntity.noContent().build();
    }
}