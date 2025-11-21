package br.com.portability.service;

import br.com.portability.domain.Portability;
import br.com.portability.domain.PortabilityStatus;
import br.com.portability.exception.PortabilityException;
import br.com.portability.repository.PortabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortabilityService {

    @Autowired
    public PortabilityRepository repository;

    public Portability save(Portability portability) {
        portability.setStatus(PortabilityStatus.PENDING);
        return repository.save(portability);
    }

    public List<Portability> findAll() {
        return repository.findAll();
    }

    public Optional<Portability> findById(String portabilityId) {
        Portability portability = repository.findById(portabilityId)
                .orElseThrow(() -> new PortabilityException("Portability not found."));
        portability.setStatus(PortabilityStatus.COMPLETED);
        return Optional.of(repository.save(portability));
    }

    public void delete(String portabilityId) {
        Portability portability = repository.findById(portabilityId)
                .orElseThrow(() -> new PortabilityException("Portability not found."));
        portability.setStatus(PortabilityStatus.CANCELLED);
        repository.save(portability);
    }
}
