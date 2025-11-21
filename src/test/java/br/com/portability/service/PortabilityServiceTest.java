package br.com.portability.service;

import br.com.portability.domain.Portability;
import br.com.portability.repository.PortabilityRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PortabilityServiceTest {

    @Mock
    private PortabilityRepository repository;

    @InjectMocks
    private PortabilityService service;

    private Portability portability;

    @Test
    void testFindAll() {
    }

}
