package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<citasDTOReactiva> cancel(String id) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva -> {
                    citasDTOReactiva.setEstadoReservaCita("cancelada");
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Flux<citasDTOReactiva> findByDate(String fecha, String hora) {
        return this.IcitasReactivaRepository.findByFechaReservaCitaAndHoraReservaCita(
                        LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d-MM-yyyy")), hora)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<String> queryMedic(String id) {
        return Mono.just(Objects.requireNonNull(this.IcitasReactivaRepository
                .findById(id).block()).getNombreMedico() + " "
                + Objects.requireNonNull(this.IcitasReactivaRepository
                .findById(id).block()).getApellidosMedico());
    }
}
