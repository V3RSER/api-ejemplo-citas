package co.com.sofka.app.repositories;

import co.com.sofka.app.models.Cita;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface iCitaRepository extends ReactiveMongoRepository<Cita, String> {
    Flux<Cita> findByIdPaciente(String idPaciente);

    Flux<Cita> findByFechaReservaCitaAndHoraReservaCita(LocalDate fechaReservaCita, String horaReservaCita);
}
