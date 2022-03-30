package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.repository.IpacientesReactivoRepository;
import com.springBajo8.springBajo8.service.IpacientesReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class pacientesReactivaServiceImpl implements IpacientesReactivaService {

    @Autowired
    private IpacientesReactivoRepository IpacientesReactivoRepository;

    @Override
    public Flux<String> queryPadecimientos(String idPaciente) {
        return Flux.just(Objects.requireNonNull(this.IpacientesReactivoRepository
                        .findById(idPaciente)
                        .block())
                .getProcedimientos());
    }

}
