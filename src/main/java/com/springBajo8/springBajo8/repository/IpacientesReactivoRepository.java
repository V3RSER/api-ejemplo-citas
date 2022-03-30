package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.pacienteDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IpacientesReactivoRepository extends ReactiveMongoRepository<pacienteDTOReactivo, String> {
}
