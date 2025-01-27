package co.com.sofka.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "pacientes")
public class Paciente {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombrePaciente;
    private String apellidosPaciente;
    private String[] procedimientos;
    private String[] padecimientos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String[] getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(String[] procedimientos) {
        this.procedimientos = procedimientos;
    }

    public String[] getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(String[] padecimientos) {
        this.padecimientos = padecimientos;
    }
}
