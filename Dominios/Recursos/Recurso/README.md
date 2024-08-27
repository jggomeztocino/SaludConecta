# Diagrama de estados del ciclo de vida del recurso
![Diagrama de estados del ciclo de vida del recurso](./Recurso/Recurso.png)

## Código fuente
El anterior diagrama de estados fue generado con la herramienta [PlantUML](https://plantuml.com/), utilizando el siguiente código fuente:

```
@startuml Recurso

skinparam maxMessageSize 100
skinparam wrapWidth 400

[*] --> Disponible : El recurso se incorpora al inventario

Disponible : El recurso está disponible para su uso
Disponible --> EnUso : Se utiliza el recurso en una consulta
Disponible --> EnMantenimiento : Se realiza mantenimiento al recurso
Disponible --> FueraDeServicio : El recurso se daña o se agota
Disponible --> Retirado : Se retira el recurso del inventario

EnUso : El recurso está siendo utilizado en una consulta médica
EnUso --> Disponible : Se finaliza el uso del recurso en la consulta asociada
EnUso --> FueraDeServicio : El recurso se daña o se agota mientras se usaba

EnMantenimiento : El recurso está siendo revisado o reparado y no está disponible para su uso
EnMantenimiento --> Disponible : Se finaliza el mantenimiento del recurso
EnMantenimiento --> Retirado : El recurso se daña mientras se mantenía y no se puede reparar

FueraDeServicio : El recurso está dañado o agotado y no puede ser utilizado
FueraDeServicio --> EnMantenimiento : Se intenta reparar o reponer el recurso
FueraDeServicio --> Retirado : El recurso no puede ser reparado o reemplazado

Retirado : El recurso ha sido retirado del inventario y no puede ser utilizado
Retirado --> Disponible : Se reingresa el recurso al inventario
Retirado --> [*] : Se elimina el recurso del inventario

@enduml
```