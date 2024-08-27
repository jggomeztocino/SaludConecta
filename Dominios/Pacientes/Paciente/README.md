# Diagrama de estados del ciclo de vida del paciente

![Diagrama de estados del ciclo de vida del paciente](./Paciente.png)

## Código fuente
El anterior diagrama de estados fue generado con la herramienta [PlantUML](https://plantuml.com/), utilizando el siguiente código fuente:

```
@startuml Paciente
skinparam maxMessageSize 100
skinparam wrapWidth 400

[*] --> Alta : El paciente se da de alta en el sistema, proporcionando sus datos personales o importándolos de un sistema externo.

Alta : El paciente no tiene ninguna enfermedad o síntoma que requiera seguimiento o intervención.
Alta --> Observacion : El paciente tiene una enfermedad o sintoma que requiere ser evaluado y seguido.
Alta --> Ingresado : El paciente tiene una enfermedad o sintoma que requiere de ingreso e/o intervención inmediata.
Alta --> Inactivo : El paciente solicita la baja voluntaria del sistema o se notifica su fallecimiento.

Observacion : El paciente tiene una enfermedad o síntoma que requiere seguimiento y pruebas adicionales.
Observacion --> Alta : El seguimiento del paciente ya no es necesario, sus condiciones han mejorado o se ha determinado que no requiere intervención.
Observacion --> Ingresado : Los síntomas empeoran o los resultados de las pruebas indican que el paciente requiere ingreso e/o intervención inmediata.
Observacion --> Inactivo : El paciente solicita la baja voluntaria del sistema o se notifica su fallecimiento.

Ingresado : El paciente tiene una enfermedad o síntoma que requiere de ingreso e/o intervención inmediata.
Ingresado --> Alta : La enfermedad o síntomas del paciente han sido sanadas y no requiere más intervención.
Ingresado --> Observacion : La enfermedad o síntomas del paciente han mejorado pero requieren seguimiento y pruebas adicionales.
Ingresado --> Inactivo : El paciente fallece.

Inactivo : El paciente es eliminado del sistema por voluntad propia o se notifica su fallecimiento. En ambos casos sus datos son archivados o anonimizados.
Inactivo --> [*] : El paciente ha sido eliminado del sistema.

@enduml
```