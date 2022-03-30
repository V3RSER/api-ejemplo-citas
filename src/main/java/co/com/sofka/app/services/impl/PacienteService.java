package co.com.sofka.app.services.impl;

import co.com.sofka.app.services.iPacienteService;
import co.com.sofka.app.repositories.iPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class PacienteService implements iPacienteService {
    @Autowired
    private iPacienteRepository repository;

    @Override
    public Flux<String> queryPadecimientos(String id) {
        return Flux.just(Objects.requireNonNull(this.repository
                        .findById(id)
                        .block())
                .getProcedimientos());
    }

}
