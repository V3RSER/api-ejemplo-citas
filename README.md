## [DOCUMENTACIÓN](https://api-ejemplo-citas.herokuapp.com/swagger-ui.html)

## Cita


```http
save
POST /cita 
```


```http
update
PUT /cita/{id}
```
```http
delete
DELETE /cita/{id}

```
```http
cancel
PUT /cita/{id}/cancelar  
```
```http
queryMedic
GET /cita/{id}/medico 
```
```http
findAllByidPaciente
GET /cita/{idPaciente}/byidPaciente 
```
```http
findByDate
GET /cita/fecha/{fecha}/{hora} 
```
```http
findAll
GET /citas 
```

## Paciente

```http
queryPadecimientos
GET /pacientes/{id}/padecimientos 
```
