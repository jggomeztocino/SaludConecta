# Event-Driven Architecture (EDA) en SaludConecta

## 1. ¿Qué es la Arquitectura Dirigida por Eventos (EDA)?

La **Arquitectura Dirigida por Eventos** (EDA) es un patrón arquitectónico en el que los sistemas se comunican mediante la producción y el consumo de eventos. Un evento es un cambio de estado significativo en el sistema, como un paciente solicitando una cita o la baja de un trabajador en el personal hospitalario. En EDA, los servicios no están directamente conectados entre sí, sino que reaccionan a los eventos que se generan, lo que permite una mayor flexibilidad y escalabilidad. Los eventos se publican en un **router de eventos** (como Apache Kafka), que se encarga de distribuirlos a los servicios interesados.

## 2. Ventajas frente al enfoque Request/Response (RR)

El enfoque **Request/Response (RR)**, en el que un servicio solicita información a otro y espera una respuesta inmediata, es común en arquitecturas tradicionales. Sin embargo, este enfoque puede presentar limitaciones en sistemas distribuidos complejos. A continuación, se detallan las ventajas de EDA frente a RR:

- **Desacoplamiento temporal**: En EDA, los servicios no necesitan estar disponibles al mismo tiempo. Los eventos se almacenan y procesan cuando los consumidores estén listos, lo que mejora la resiliencia ante caídas temporales de los servicios. Esto permite, por ejemplo, que un servicio produzca sin preocuparse de quién lo consumirá o cuándo y viceversa con los servicios consumidores.
  
- **Desacoplamiento espacial**: Los servicios no necesitan conocer la ubicación ni la identidad de los otros servicios con los que interactúan. Solo necesitan suscribirse a eventos de interés, eliminando dependencias directas entre ellos.
  
- **Escalabilidad reactiva**: En lugar de manejar picos de tráfico con solicitudes síncronas, EDA permite que los servicios reaccionen a los eventos y escalen de manera independiente según la carga que reciben.
  
- **Persistencia histórica**: Los eventos pueden almacenarse de forma indefinida, permitiendo a nuevos servicios procesar eventos pasados para reconstruir estados o reanalizar datos. Esto es especialmente útil para auditoría o análisis posteriores.

## 3. Otros beneficios de EDA

Además de las ventajas mencionadas, EDA ofrece varios beneficios adicionales:

- **Flexibilidad y extensibilidad**: Al agregar nuevos servicios, estos pueden suscribirse a eventos ya existentes sin afectar a los demás. Esto facilita la evolución del sistema sin necesidad de reescribir grandes porciones de código.
  
- **Resiliencia**: Si un servicio falla, el sistema puede continuar operando. El router de eventos se encarga de entregar los eventos cuando el servicio vuelva a estar disponible, lo que aumenta la tolerancia a fallos.
  
- **Procesamiento en paralelo**: Los eventos pueden ser procesados simultáneamente por diferentes servicios, permitiendo que tareas como la asignación de recursos y la validación de citas ocurran en paralelo, mejorando el rendimiento general del sistema.

## 4. ¿Por qué es ideal para SaludConecta?

En el proyecto **SaludConecta**, la **arquitectura dirigida por eventos** (EDA) es ideal por varias razones:

- **Desacoplamiento de servicios**: Cada dominio (Pacientes, Citas, Personal, Recursos) puede trabajar de forma autónoma, respondiendo a los eventos relevantes para su contexto. Esto mejora la modularidad del sistema, haciéndolo más fácil de mantener y escalar.
  
- **Resiliencia crítica**: En un entorno hospitalario, es fundamental que el sistema no colapse si uno de los servicios está caído. EDA asegura que si, por ejemplo, el servicio de médicos o el de recursos falla temporalmente, las solicitudes de citas pueden seguir procesándose cuando esos servicios vuelvan a estar disponibles.
  
- **Escalabilidad flexible**: Durante picos de actividad el sistema puede escalar dinámicamente según las necesidades, sin afectar a otros componentes del sistema.

## Referencias

- [What is Event Driven Architecture (EDA)? - IBM Technology](https://www.youtube.com/watch?v=o2HJCGcYwoU)
- [4 Key Types of Event-Driven Architecture - Confluent](https://www.youtube.com/watch?v=J-kKR3omk-g)
- [Event-Driven Architecture (EDA) vs Request/Response (RR) - Confluent](https://www.youtube.com/watch?v=7fkS-18KBlw)
- [What is an Event-Driven Architecture? - AWS](https://aws.amazon.com/event-driven-architecture/#:~:text=An%20event%2Ddriven%20architecture%20uses,on%20an%20e%2Dcommerce%20website.)
- [Arquitecturas orientada a eventos: Conceptos y aplicación práctica - Daniel Brandi](https://www.youtube.com/watch?v=pqTpFCIjVFs)