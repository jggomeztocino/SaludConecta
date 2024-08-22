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
- `HistorialMédico`: Almacena el historial médico de un paciente, incluyendo diagnósticos, tratamientos y visitas médicas.

### 2. Personal

#### Responsabilidades
- Gestión de la información personal y profesional de todo el personal del hospital, incluyendo médicos, personal de limpieza, mantenimiento, y administrativo.
- Asignación de roles y permisos a los miembros del personal.
- Gestión de la disponibilidad y asignación de turnos de trabajo.
- Registro y seguimiento de la asistencia del personal.
- Coordinación y comunicación entre los miembros del personal de diferentes áreas.

#### Entidades
- `Empleado`: Representa a un miembro del personal del hospital, con su información personal y profesional.
- `Rol`: Define los roles y permisos que puede tener un miembro del personal, incluyendo sus responsabilidades específicas.
- `Turno`: Define los horarios y turnos de trabajo de un miembro del personal.
- `Asistencia`: Registra la asistencia de un miembro del personal.

### 3. Citas

#### Responsabilidades
- Gestión integral de las citas médicas, incluyendo su creación, modificación y cancelación.
- Coordinación entre pacientes, personal médico y recursos para asegurar la disponibilidad necesaria.
- Registro y seguimiento de las consultas médicas asociadas a cada cita.

#### Entidades
- `Cita`: Representa una cita médica entre un paciente y un médico, con información sobre la fecha, hora, duración, y estado.
- `Consulta`: Representa una consulta médica realizada durante una cita, con información sobre el diagnóstico, tratamiento y observaciones.

### 4. Recursos

#### Responsabilidades
- Gestión de los recursos y equipos médicos disponibles en el hospital.
- Control de inventario y planificación de mantenimiento de los recursos.
- Asignación y reserva de recursos para las citas y consultas médicas.
- Monitoreo de la disponibilidad y uso de los recursos en tiempo real.

#### Entidades
- `Recurso`: Representa un recurso o equipo médico, con información sobre el tipo, cantidad, estado y ubicación.
- `Inventario`: Almacena la información sobre la cantidad y estado de los recursos disponibles.
- `Asignación`: Representa la asignación de un recurso a una cita o consulta médica específica.
- `Mantenimiento`: Registra las actividades de mantenimiento y reparación de un recurso.
- `Disponibilidad`: Registra la disponibilidad y uso actual de un recurso.

### 5. Monitorización y Análisis

#### Responsabilidades
- Monitorización continua del rendimiento y disponibilidad de los servicios.
- Análisis de datos y generación de informes para mejorar la eficiencia operativa.
- Detección de anomalías y generación de alertas.

#### Entidades
- `Métrica`: Representa una métrica específica para el monitoreo de rendimiento o uso del sistema.
- `Informe`: Genera un informe basado en el análisis de las métricas recolectadas.
- `Alerta`: Notificación generada en caso de detectar un comportamiento anómalo o un problema en el sistema.

### 6. Seguridad (Autenticación y Autorización)

#### Responsabilidades
- Gestión de la autenticación y autorización de usuarios en el sistema.
- Provisión de mecanismos de seguridad para garantizar el acceso seguro a los recursos y servicios.
- Administración de roles y permisos para los usuarios.

#### Entidades
- `Usuario`: Representa a un usuario del sistema, con su información de autenticación y roles asociados.
- `Token`: Mecanismo de seguridad para autenticar las solicitudes del usuario.
- `Permiso`: Define los niveles de acceso permitidos a un usuario o rol específico.
