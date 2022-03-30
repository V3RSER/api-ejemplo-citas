package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.service.IpacientesReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class pacientesReactivoResource {

    @Autowired
    private IpacientesReactivaService ipacientesReactivaService;

    @GetMapping("/pacientesReactivos/{idPaciente}/padecimientos")
    private Flux<String> queryPadecimientos(@PathVariable("idPaciente") String idPaciente) {
        return this.ipacientesReactivaService.queryPadecimientos(idPaciente);
    }
}
