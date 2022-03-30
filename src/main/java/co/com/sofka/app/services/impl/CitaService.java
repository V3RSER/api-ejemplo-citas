package co.com.sofka.app.services.impl;

import co.com.sofka.app.models.Cita;
import co.com.sofka.app.repositories.iCitaRepository;
import co.com.sofka.app.services.iCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class CitaService implements iCitaService {

    @Autowired
    private iCitaRepository repository;

    @Override
    public Mono<Cita> save(Cita cita) {
        return this.repository.save(cita);
    }

    @Override
    public Mono<Cita> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<Cita> update(String id, Cita cita) {
        return this.repository.findById(id)
                .flatMap(cita1 -> {
                    cita.setId(id);
                    return save(cita);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Cita> cancel(String id) {
        return this.repository.findById(id)
                .flatMap(cita -> {
                    cita.setEstadoReservaCita("cancelada");
                    return save(cita);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Cita> findByIdPaciente(String idPaciente) {
        return this.repository.findByIdPaciente(idPaciente);
    }

    @Override
    public Flux<Cita> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Cita> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Flux<Cita> findByDate(String fecha, String hora) {
        return this.repository.findByFechaReservaCitaAndHoraReservaCita(
                        LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d-MM-yyyy")), hora)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<String> queryMedic(String id) {
        return Mono.just(Objects.requireNonNull(this.repository
                .findById(id).block()).getNombreMedico() + " "
                + Objects.requireNonNull(this.repository
                .findById(id).block()).getApellidosMedico());
    }
}
