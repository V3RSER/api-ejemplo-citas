package co.com.sofka.app.repositories;

import co.com.sofka.app.models.Paciente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface iPacienteRepository extends ReactiveMongoRepository<Paciente, String> {
}
