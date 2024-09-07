
# Arquitectura Hexagonal en SaludConecta

## 1. ¿Qué es la Arquitectura Hexagonal?

La **Arquitectura Hexagonal**, también conocida como **Arquitectura de Puertos y Adaptadores**, es un patrón arquitectónico que se centra en desacoplar el **núcleo de negocio** de una aplicación de sus mecanismos de entrada y salida (interfaces con el mundo externo). La idea principal es que el dominio central o la lógica de negocio sea completamente independiente de la infraestructura, interfaces de usuario, bases de datos, o cualquier otro sistema externo, de tal forma que los cambios en estas tecnologías no afecten el comportamiento del núcleo.

Este modelo plantea que la lógica de negocio solo interactúa con el exterior a través de **puertos** (interfaces) y **adaptadores**, que son los encargados de hacer las conversiones necesarias para que el sistema se comunique con tecnologías externas, como bases de datos, APIs u otros servicios.

![Arquitectura Hexagonal](https://wata.es/wp-content/uploads/2021/05/diagrama-arquitectura-hexagonal-wata-factory-1024x796.png "Arquitectura Hexagonal")

## 2. Elementos claves en el hexágono y sus responsabilidades

En una arquitectura hexagonal típica, el sistema se divide en tres capas principales:

- **Dominio**: Es el núcleo de la aplicación y contiene las reglas de negocio. Es completamente independiente de la infraestructura y se mantiene libre de detalles técnicos. Aquí se encuentran los **entidades**, **agregados** y **servicios de dominio** que representan la lógica fundamental de la aplicación.

    - **Puertos**: Son las interfaces que permiten la comunicación entre el dominio y el mundo exterior. Por ejemplo, un puerto de repositorio define cómo se accede a los datos, pero no especifica cómo se almacenan. Los puertos son implementados por los adaptadores.
    - **Adaptadores**: Son los encargados de conectar los puertos del dominio con las tecnologías externas. Por ejemplo, un adaptador de base de datos implementa el puerto de repositorio utilizando una base de datos concreta. Los adaptadores convierten las llamadas del dominio en operaciones específicas de la tecnología externa.

- **Aplicación**: Contiene los casos de uso o servicios de aplicación. Actúa como intermediario entre el dominio y los adaptadores, manejando la lógica que conecta los eventos externos (entradas) con las operaciones de negocio del dominio.

- **Infraestructura**: En esta capa se encuentran los **adaptadores**, que se encargan de conectar los puertos del sistema con las tecnologías externas (bases de datos, APIs, sistemas de mensajería, etc.).

## 3. Ventajas frente a la arquitectura tradicional (3 capas)

A diferencia de la arquitectura en capas tradicional, donde las capas de presentación, lógica y datos están fuertemente acopladas, la arquitectura hexagonal permite una separación estricta entre el dominio y las capas de infraestructura. Esto ofrece varias ventajas:

- **Independencia tecnológica**: El núcleo de la aplicación no depende de tecnologías específicas como bases de datos, APIs o frameworks externos. Los cambios en estas tecnologías no afectan la lógica de negocio.
  
- **Fácil de mantener y extender**: Como cada parte de la aplicación está desacoplada, cambiar un componente (por ejemplo, cambiar la base de datos de MySQL a PostgreSQL) es más sencillo, ya que solo se necesita modificar el adaptador correspondiente sin tocar la lógica de negocio.
  
- **Testabilidad**: La arquitectura hexagonal permite realizar pruebas unitarias más fácilmente, ya que la lógica de negocio está aislada y no depende de la infraestructura externa. Es decir, al estar los componentes desacoplados y separados por interfaces, es más fácil simular las interacciones externas, motivo por el cual la creación de pruebas unitarias y de integración es más sencilla.

- **Escalabilidad y flexibilidad**: Los adaptadores permiten añadir nuevas entradas o salidas (APIs, bases de datos, colas de mensajería) sin modificar el núcleo de la aplicación, haciendo el sistema más flexible y preparado para cambios futuros.

## 4. ¿Por qué es ideal para SaludConecta?

La arquitectura hexagonal es ideal para **SaludConecta** por varias razones clave:

- **Modularidad del sistema**: SaludConecta es una plataforma que requiere la interacción de múltiples servicios (gestión de citas, recursos, médicos, notificaciones, etc.). La arquitectura hexagonal permite que estos servicios sean fácilmente intercambiables y extensibles sin impactar al núcleo del sistema, lo cual es crucial en un entorno donde pueden surgir nuevos requerimientos y tecnologías.

- **Independencia tecnológica**: En SaludConecta, es probable que existan diversos sistemas de terceros, bases de datos y APIs que deban interactuar con la aplicación. Con la arquitectura hexagonal, el sistema puede soportar diferentes tecnologías externas sin tener que modificar la lógica de negocio, asegurando que el sistema se mantenga estable y escalable a medida que crece.

- **Fácil integración con microservicios**: Esta arquitectura se integra perfectamente con los **microservicios** que SaludConecta puede usar. Cada microservicio puede tener su propio hexágono, con puertos y adaptadores específicos que permiten que el núcleo de la aplicación funcione de manera independiente a los detalles tecnológicos de cada servicio.

## Caso de uso de ejemplo en SaludConecta

Imaginemos un escenario en SaludConecta donde un paciente solicita una cita médica. El flujo básico usando arquitectura hexagonal podría verse así:

1. **Puerto de entrada**: El servicio de citas recibe la solicitud del paciente a través de una API REST. Este es un **adaptador** que convierte la solicitud HTTP en una llamada al caso de uso relevante en la capa de aplicación, iniciando el proceso de validación de la información proporcionada y asegurando que no haya citas duplicadas.
   
2. **Dominio**: El caso de uso "Solicitar Cita" en la capa de dominio se encarga de generar el evento `AppointementRequested`, pre-asignando una fecha, hora, médico y consulta a la solicitud de cita. Esta lógica de negocio está completamente encapsulada en el dominio, sin conocimiento de los sistemas externos, como bases de datos o servicios de mensajería.

3. **Puertos de salida**: 
   - La información sobre la pre-asignación de la cita (fecha, hora, médico, consulta) es registrada a través de un **adaptador** que genera el evento `AppointementCreated`.
   - El servicio de personal, mediante otro **adaptador**, escucha el evento `AppointementCreated`, verifica la disponibilidad del médico, y si es posible, genera el evento `DoctorAssigned`.
   - De manera similar, el servicio de recursos escucha `AppointementCreated` y comprueba la disponibilidad de la consulta, generando el evento `RoomReserved` si está disponible.

4. **Reacciones a eventos**: 
   - El servicio de gestión de citas escucha tanto los eventos `DoctorAssigned` como `RoomReserved`, y en consecuencia, registra la cita final, asignando el estado "Pendiente" a la cita y el estado "Programada" a la consulta asociada. Tras esto, se generan los eventos `AppointmentCreated` y `ConsultationCreated` para su seguimiento.

5. **Notificación**: Finalmente, el servicio de notificaciones escucha el evento `AppointmentCreated` y, mediante su propio **adaptador**, envía notificaciones tanto al paciente como al médico sobre la cita creada. Este proceso es gestionado sin que el dominio tenga conocimiento de la infraestructura de notificaciones utilizada.

### Referencias

- [Hexagonal Architecture: What You Need To Know - Alex Hyett](https://www.youtube.com/watch?v=bDWApqAUjEI&t=3s)
- [Arquitectura hexagonal - CodelyTV](https://www.youtube.com/watch?v=eNFAJbWCSww)
- [Hexagonal Architecture I - Medium](https://medium.com/mcdonalds-technical-blog/hexagonal-architecture-for-cloud-ecosystems-5a5ec6d4126b)
- [Hexagonal Architecture II - Medium](https://medium.com/mcdonalds-technical-blog/hexagonal-architectures-the-sequel-073c9ee79385)
- [Hexagonal Architecture - Wata](https://wata.es/hexagonal-architecture-introduction-and-structure/)