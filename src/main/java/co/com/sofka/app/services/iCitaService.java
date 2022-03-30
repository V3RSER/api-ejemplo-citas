package co.com.sofka.app.services;

import co.com.sofka.app.models.Cita;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iCitaService {
    Mono<Cita> save(Cita cita);

    Mono<Cita> delete(String id);

    Mono<Cita> update(String id, Cita cita);

    Mono<Cita> cancel(String id);

    Flux<Cita> findByIdPaciente(String idPaciente);

    Flux<Cita> findAll();

    Mono<Cita> findById(String id);

    Flux<Cita> findByDate(String fecha, String hora);

    Mono<String> queryMedic(String id);
}
