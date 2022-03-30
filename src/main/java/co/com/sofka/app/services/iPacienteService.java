package co.com.sofka.app.services;

import reactor.core.publisher.Flux;

public interface iPacienteService {
    Flux<String> queryPadecimientos(String id);
}



