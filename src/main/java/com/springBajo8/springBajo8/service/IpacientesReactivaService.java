package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;

import reactor.core.publisher.Flux;

public interface IpacientesReactivaService {
    Flux<String> queryPadecimientos(String idPaciente);
}



