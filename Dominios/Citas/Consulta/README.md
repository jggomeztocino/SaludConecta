# Diagrama de estados del ciclo de vida de la consutla

![Diagrama de estados del ciclo de vida de la consulta](./Consulta.png)

## Código fuente
El anterior diagrama de estados fue generado con la herramienta [PlantUML](https://plantuml.com/), utilizando el siguiente código fuente:

```
@startuml Consulta

skinparam maxMessageSize 100
skinparam wrapWidth 400

[*] --> Programada : Se crea una nueva consulta

Programada : La consulta ha sido programada y está a la espera de ser llevada a cabo por el paciente y el médico
Programada --> EnCurso : El paciente y el médico se reúnen en la consulta
Programada --> Cancelada : El paciente o el médico cancelan la consulta. Se contempla también la cancelación por parte del sistema

EnCurso : La consulta está en curso, es decir, el médico y el paciente están reunidos y llevando a cabo la atención médica
EnCurso --> Finalizada : La consulta finaliza

Cancelada : La consulta ha sido cancelada por el médico o el paciente, y no se llevará a cabo
Cancelada --> [*] : Se cancela la consulta

Finalizada : La consulta ha finalizado y se han registrado los resultados y tratamientos correspondientes
Finalizada --> [*] : Se finaliza la consulta

@enduml
```