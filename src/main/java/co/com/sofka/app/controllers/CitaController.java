package co.com.sofka.app.controllers;

import co.com.sofka.app.models.Cita;
import co.com.sofka.app.services.iCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CitaController {
    @Autowired
    private iCitaService service;

    @PostMapping("/cita")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cita> save(@RequestBody Cita cita) {
        return this.service.save(cita);
    }

    @DeleteMapping("/cita/{id}")
    private Mono<ResponseEntity<Cita>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(cita -> Mono.just(ResponseEntity.ok(cita)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/cita/{id}")
    private Mono<ResponseEntity<Cita>> update(@PathVariable("id") String id, @RequestBody Cita cita) {
        return this.service.update(id, cita)
                .flatMap(cita1 -> Mono.just(ResponseEntity.ok(cita1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/cita/{id}/cancelar")
    private Mono<ResponseEntity<Cita>> cancel(@PathVariable("id") String id) {
        return this.service.cancel(id)
                .flatMap(cita1 -> Mono.just(ResponseEntity.ok(cita1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/cita/{idPaciente}/byidPaciente")
    private Flux<Cita> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.service.findByIdPaciente(idPaciente);
    }

    @GetMapping("/citas")
    private Flux<Cita> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/cita/{id}/medico")
    private Mono<String> queryMedic(@PathVariable("id") String id) {
        return this.service.queryMedic(id);
    }

    @GetMapping("/cita/fecha/{fecha}/{hora}")
    private Flux<Cita> findByDate(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
        return this.service.findByDate(fecha, hora);
    }
}
