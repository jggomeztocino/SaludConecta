# Dominios

## ¿Qué es un dominio?

En la arquitectura hexagonal, un **dominio** es un área de conocimiento o responsabilidad que se encapsula en un microservicio. Cada dominio es independiente y se comunica con otros dominios a través de eventos y puertos, siguiendo el principio de separación de responsabilidades. Los dominios son la base de la arquitectura hexagonal, permitiendo que el sistema sea modular, escalable y altamente flexible.

## Dominios de SaludConecta

SaludConecta está compuesto por varios dominios, cada uno gestionando un aspecto específico del sistema. A continuación se detallan los principales dominios de SaludConecta:

### 1. Pacientes

#### Responsabilidades
- Gestión de la información personal y médica de los pacientes.
- Almacenamiento y actualización del historial médico.
- Proporcionar información relevante a otros dominios cuando se realiza una consulta o cita.

#### Entidades
- `Paciente`: Representa a un paciente en el sistema, con su información personal y médica.
- `HistorialMédico`: Véase como un expediente. Existirá un historial médico principal por cada paciente, que contendrá la información más relevante y actualizada sobre su estado de salud. Por cada caso específico o temporal (como una enfermedad o lesión), se creará un nuevo historial médico que se asociará al paciente en cuestión.

### 2. Personal

#### Responsabilidades
- Gestión de la información personal y profesional de todo el personal del hospital, incluyendo médicos, personal de limpieza, mantenimiento, y administrativo.
- Gestión de la disponibilidad y asignación de turnos de trabajo para asegurar la cobertura adecuada en todas las áreas.
- Coordinación de los miembros del personal de diferentes áreas para garantizar una operación eficiente y sin interrupciones.

#### Entidades
- **`Empleado`**: Representa a un miembro del personal del hospital, incluyendo su información personal, profesional y el rol que desempeña dentro del hospital.
- **`Turno`**: Define los horarios y turnos de trabajo asignados a cada miembro del personal, gestionando la disponibilidad y asegurando que todos los turnos sean cubiertos de manera efectiva.

### 3. Citas

#### Responsabilidades
- Coordinación de citas y consultas médicas entre pacientes y médicos.
- Asignación de recursos y equipos médicos necesarios para cada consulta.
- Registro y seguimiento de las citas y consultas realizadas, incluyendo información sobre el estado y resultados.

#### Entidades
- `Cita`: Representa una cita médica entre un paciente y una consulta, con información sobre la fecha, hora, consulta asociada y estado de la cita.
- `Consulta`: Define una reunión entre un médico y un paciente, con información sobre el médico, paciente, motivo de la consulta y resultados.

### 4. Recursos

#### Responsabilidades
- Gestión de los recursos y equipos médicos disponibles en el hospital.
- Control de inventario y planificación de mantenimiento de los recursos.
- Asignación y reserva de recursos para las citas y consultas médicas.
- Monitoreo de la disponibilidad y uso de los recursos en tiempo real.

#### Entidades
- `Recurso`: Representa un recurso o equipo médico, con información sobre el tipo, cantidad, estado y ubicación.
- `Asignación`: Representa la asignación de un recurso a una cita o consulta médica específica.

### 5. Monitorización y Análisis (?)

#### Responsabilidades
- Monitorización continua del rendimiento y disponibilidad de los servicios.
- Análisis de datos y generación de informes para mejorar la eficiencia operativa.
- Detección de anomalías y generación de alertas.

#### Entidades
- `Métrica`: Representa una métrica específica para el monitoreo de rendimiento o uso del sistema. (?)
- `Informe`: Genera un informe basado en el análisis de las métricas recolectadas. (?)
- `Alerta`: Notificación generada en caso de detectar un comportamiento anómalo o un problema en el sistema. (?)