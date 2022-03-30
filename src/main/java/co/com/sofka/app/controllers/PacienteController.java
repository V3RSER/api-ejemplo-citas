package co.com.sofka.app.controllers;

import co.com.sofka.app.services.iPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PacienteController {
    @Autowired
    private iPacienteService service;

    @GetMapping("/pacientes/{id}/padecimientos")
    private Flux<String> queryPadecimientos(@PathVariable("id") String id) {
        return this.service.queryPadecimientos(id);
    }
}
