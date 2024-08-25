# Diagrama de estados del ciclo de vida del empleado

![Diagrama de estados del ciclo de vida del empleado](./Empleado.png)

## Código fuente
El anterior diagrama de estados fue generado con la herramienta [PlantUML](https://plantuml.com/), utilizando el siguiente código fuente:

```
@startuml Empleado

skinparam maxMessageSize 100
skinparam wrapWidth 400

[*] --> Alta : El empleado se da de alta en el sistema, proporcionando sus datos personales o importándolos de un sistema externo.

Alta : El empleado está activo en el sistema y tiene un rol asignado
Alta --> Trabajando : El empleado empieza su turno en el hospital
Alta --> Baja : El empleado solicita una baja temporal por motivos personales o profesionales
Alta --> Suspendido : El empleado comete una falta grave y es suspendido temporalmente
Alta --> Retirado : El empleado solicita su baja definitiva en el hospital o alcanza la edad de jubilación

Trabajando : El empleado está actualmente trabajando en el hospital y cumpliendo con sus responsabilidades
Trabajando --> Alta : El empleado finaliza su turno en el hospital
Trabajando --> Baja : El empleado sufre un accidente laboral mientras realiza su turno
Trabajando --> Suspendido : El empleado comete una falta grave durante su turno

Baja : El empleado está de baja temporal por motivos personales o profesionales
Baja --> Alta : El empleado se reincorpora a su puesto de trabajo
Baja --> Suspendido : El empleado comete una falta grave durante su baja

Suspendido : El empleado está suspendido temporalmente por motivos disciplinarios
Suspendido --> Alta : La dirección del hospital levanta la suspensión
Suspendido --> Retirado : La dirección del hospital decide retirar al empleado del hospital

Retirado : El empleado ha dejado de trabajar en el hospital
Retirado --> [*] : El empleado es eliminado del sistema (sus datos se archivan)

@enduml
```