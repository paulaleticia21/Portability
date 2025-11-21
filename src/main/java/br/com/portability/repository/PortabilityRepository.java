package br.com.portability.repository;

import br.com.portability.domain.Portability;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortabilityRepository  extends MongoRepository<Portability, String> {
}
