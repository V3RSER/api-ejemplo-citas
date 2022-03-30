package co.com.sofka.app;

import co.com.sofka.app.models.Paciente;
import co.com.sofka.app.repositories.iPacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringReactivoApplicationTests {
    @Autowired
    iPacienteRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void crearPacienteTest() {
        Paciente pacientetest = new Paciente();
        pacientetest.setNombrePaciente("Jose");
        pacientetest.setApellidosPaciente("Gonzales");
        pacientetest.setProcedimientos(new String[]{"Dormir", "Descansar"});
        pacientetest.setPadecimientos(new String[]{"Cansancio"});
        Mono<Paciente> pacienteGuardado = repository.save(pacientetest);

        StepVerifier.create(pacienteGuardado).expectNext(pacientetest).expectComplete().verify();
    }

}
