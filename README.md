# SaludConecta

## Descripción y objetivo del proyecto

**SaludConecta** es un sistema avanzado de gestión de coordinación de citas médicas, diseñado para optimizar la eficiencia y seguridad en un entorno hospitalario. El proyecto se basa en tecnologías y principios modernos como la **Arquitectura Hexagonal**, **Arquitectura Dirigida por Eventos (EDA)** y **Microservicios**. Estos principios permiten que el sistema sea modular, escalable y altamente flexible, adecuado para entornos que requieren alta disponibilidad y procesamiento en tiempo real.

### Principios Clave:

- **Arquitectura Hexagonal**: Este diseño facilita la separación de la lógica de negocio de las dependencias externas (como bases de datos y APIs), permitiendo que los microservicios de SaludConecta sean fácilmente mantenibles y extensibles. Cada microservicio se encapsula dentro de un "hexágono", donde las entradas y salidas están definidas por puertos y adaptadores.

- **Arquitectura Dirigida por Eventos (EDA)**: En lugar de operar bajo un modelo de consulta constante para detectar cambios, SaludConecta adopta un enfoque basado en eventos, donde los microservicios reaccionan inmediatamente a los cambios relevantes. Esto significa que las operaciones críticas, como la creación o cancelación de citas, desencadenan eventos que son procesados por los microservicios interesados, garantizando una respuesta rápida y eficiente.

- **Microservicios con Docker y Kubernetes**: SaludConecta está compuesto por varios microservicios, cada uno gestionando un dominio específico (Pacientes, Personal, Citas, Recursos, etc.). Estos microservicios se despliegan en contenedores Docker y se orquestan utilizando Kubernetes, asegurando escalabilidad, resiliencia y fácil gestión en entornos de producción.

## Stack

- **Docker & Kubernetes**: Utilizados para contenerizar y orquestar los microservicios, permitiendo un despliegue escalable y automatizado, garantizando la alta disponibilidad y resiliencia del sistema.

- **Spring Framework**: Basado en **Java**, el Spring Framework facilita la implementación de microservicios con una arquitectura robusta y modular. Al aprovechar Spring Boot, SaludConecta puede desarrollar rápidamente microservicios que adhieren a los principios de la arquitectura hexagonal, asegurando la separación de preocupaciones y la independencia del código. Java, como lenguaje maduro y ampliamente adoptado, ofrece estabilidad, rendimiento y una rica ecosistema de bibliotecas y herramientas que fortalecen el desarrollo del proyecto.

- **Kafka & Kafka Streams**: Kafka actúa como el bus de eventos central de SaludConecta, permitiendo la comunicación entre microservicios de manera asíncrona. Kafka Streams se utiliza para el procesamiento en tiempo real de los eventos, permitiendo la transformación y el enrutamiento de los datos sin la necesidad de bases de datos intermediarias.

- ~~**Hyperledger Fabric**: Implementa la **Distributed Ledger Technology (DLT)** para registrar de manera inmutable y segura las transacciones críticas, como la gestión de citas y consentimientos médicos, garantizando la transparencia y la trazabilidad de los datos en todo momento.~~

- **~~PostgreSQL /~~ MongoDB**: Dependiendo de las necesidades específicas de cada microservicio, se utiliza ~~PostgreSQL para datos relacionales y~~ MongoDB para datos no relacionales, permitiendo una flexibilidad óptima en la gestión de los datos.

_Actualización_: Aunque en un principio se plantease usar PostgreSQL, la gran diversidad de los datos médicos y personales a almacenar hacen replantear el uso de un esquema relacional (fijo) para este propósito.

- **Prometheus y Grafana**: Utilizados para la monitorización y visualización del rendimiento del sistema, asegurando que todos los microservicios se comportan de manera óptima y facilitando la detección de anomalías o cuellos de botella en tiempo real.

## Licencia

Este proyecto está licenciado bajo la Licencia Apache 2.0.

#### Desarrollado por Jesús Gómez - 2024. 
