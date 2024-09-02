# La infraestructura de gestión de eventos: Apache Kafka

## ¿Qué es Apache Kafka?

Apache Kafka es una plataforma de streaming de eventos de código abierto que se utiliza para construir pipelines de datos en tiempo real y aplicaciones de streaming. Kafka es ampliamente utilizado en aplicaciones críticas en tiempo real, como aplicaciones de comercio electrónico, monitoreo de IoT y análisis en tiempo real.

Kafka permite la **publicación** y **suscripción** a flujos de registros (también llamados eventos o mensajes), el almacenamiento de estos registros de manera persistente, y el procesamiento de estos flujos de datos en tiempo real. 

## Conceptos clave

A continuación, se detallan algunos conceptos clave a la hora de trabajar con Apache Kafka:

### 1. **Tópicos**
- Un **tópico** es un canal de comuniación que representa a una categoría a la cual los registros son enviados y del cual los consumidores pueden leer.
- Los tópicos se pueden particionar, es decir, pueden dividirse en múltiples partes llamadas **particiones**. Cada partición es, en esencia, un log ordenado e inmutable de registros/mensajes.

### 2. **Particiones**
- Una **partición** es un segmento de un tópico que permite escalar el procesamiento de datos. Las particiones permiten que un tópico se distribuya entre varios brokers y facilitan la paralelización del procesamiento de datos.
- Cada registro en una partición tiene un **offset**, que es un identificador único que indica su posición en la partición.

### 3. **Brokers**
- Un **broker** es un servidor Kafka que recibe y almacena los registros de los productores y los sirve a los consumidores.
- Un clúster de Kafka se compone de múltiples brokers que trabajan juntos para manejar la carga y asegurar la disponibilidad.

### 4. **Controladores**
- El **controlador** es un broker especial en un clúster de Kafka que es responsable de la coordinación y el mantenimiento del estado del clúster.
- El controlador elige un líder para cada partición y maneja la reasignación de particiones en caso de fallo de un broker.

### 5. **Réplicas**
- Las **réplicas** son copias de las particiones de un tópico. Cada partición puede tener varias réplicas distribuidas en diferentes brokers.
- Las réplicas proporcionan tolerancia a fallos, ya que si un broker falla, las réplicas en otros brokers pueden asumir el rol de líder y continuar sirviendo los datos.

### 6. **Líderes y brokers réplicas**
- Para cada partición, uno de los brokers es el **líder** que maneja todas las operaciones de lectura y escritura para esa partición.
- Los **brokers réplicas** simplemente replican los datos desde el líder y no manejan operaciones de clientes a menos que se conviertan en líderes en caso de fallo del líder actual.

### 7. **Productores y consumidores**
- Un **productor** es una aplicación que publica registros en un tópico de Kafka.
- Un **consumidor** es una aplicación que se suscribe a un tópico para leer y procesar los registros.

### 8. **Grupos de consumidores**
- Consiste en múltiples consumidores que colaboran para leer mensajes de un tópico.
- Kafka distribuye automáticamente las particiones de un tópico entre los consumidores en el grupo.
- Un mismo consumidor puede leer múltiples particiones, pero una partición solo puede ser leída por un consumidor en un grupo.
- Si hay más consumidores que particiones, algunos consumidores permanecerán inactivos, ya que no habrá suficientes particiones para asignarles.
- Dentro del grupo, Kafka garantiza que cada partición sea leída por un solo consumidor a la vez.
- Los consumidores de un grupo comparten el estado del offset, lo que permite que los consumidores se reinicien o desactiven sin perder el progreso de lectura.
- En caso de que un consumidor falle o se desactive, Kafka reasigna automáticamente las particiones a otros consumidores activos en el grupo.

## El papel de Kafka en arquitecturas dirigidas por eventos (EDA) y microservicios

### Arquitecturas Dirigidas por Eventos (EDA)

En una arquitectura dirigida por eventos, los sistemas y servicios se comunican entre sí a través de eventos. Kafka juega un papel crucial como intermediario de mensajes que permite que los eventos sean emitidos, almacenados y procesados de manera asíncrona.

- **Desacoplamiento**: Kafka permite que los productores y consumidores de eventos estén desacoplados. Los productores pueden emitir eventos sin preocuparse por la disponibilidad de los consumidores.
- **Escalabilidad**: Gracias a su arquitectura basada en particiones, Kafka puede manejar grandes volúmenes de datos y escalar horizontalmente añadiendo más brokers.
- **Persistencia**: Kafka almacena los eventos en un log persistente, lo que permite que los consumidores se suscriban a eventos pasados y reprocesen datos según sea necesario.

### Microservicios

En una arquitectura de microservicios, los servicios individuales son responsables de diferentes funcionalidades y se comunican entre sí mediante mensajes o eventos. Kafka proporciona una plataforma robusta para la integración de microservicios a través de la mensajería asíncrona.

- **Resiliencia**: Kafka ofrece mecanismos para garantizar que los mensajes no se pierdan, incluso si un servicio está temporalmente caído. Los mensajes se almacenan hasta que el servicio esté listo para procesarlos.
- **Consistencia Eventual**: Kafka facilita la consistencia eventual al permitir que los servicios publiquen eventos y otros servicios reaccionen a esos eventos para mantener su estado en sincronía.

## Comparación con MQTT

### ¿Qué es MQTT?

MQTT (Message Queuing Telemetry Transport) es un protocolo de mensajería ligero diseñado para dispositivos con recursos limitados y redes con ancho de banda reducido, como en el Internet de las Cosas (IoT). Es adecuado para situaciones donde los mensajes son pequeños y la comunicación debe ser eficiente.

### Diferencias principales

1. **Propósito y uso**:
   - **Kafka**: Está diseñado para manejar flujos de datos masivos en tiempo real y es ideal para aplicaciones que requieren alta escalabilidad, fiabilidad y procesamiento en tiempo real.
   - **MQTT**: Se principal aplicación son los dispositivos IoT, ya que está enfocado en la eficiencia y simplicidad. Es adecuado para casos de uso donde los dispositivos tienen recursos limitados y los mensajes son pequeños y esporádicos.

2. **Persistencia de datos**:
   - **Kafka**: Almacena los mensajes de forma persistente, lo que permite a los consumidores leer y procesar datos en diferentes momentos y reprocesar eventos pasados.
   - **MQTT**: De no implementarse, por defecto, no almacena mensajes de manera persistente.

3. **Escalabilidad**:
   - **Kafka**: Puede escalar horizontalmente para manejar grandes volúmenes de datos y miles de clientes simultáneamente gracias a su arquitectura basada en particiones.
   - **MQTT**: Está diseñado para ser ligero y no maneja la misma escala de datos que Kafka. Es más adecuado para redes con recursos limitados y no está diseñado para procesamiento masivo de datos.

4. **Modelos de comunicación**:
   - **Kafka**: Soporta modelos de comunicación complejos como publicación/suscripción, stream processing, y almacenamiento de logs, con capacidades de replicación y tolerancia a fallos.
   - **MQTT**: Se centra en un simple modelo publicación/suscripción.

## ¿Por qué se ha elegido Kafka?
En un sistema de gestión hospitalaria, donde la gestión y coordinación entre dominios debe ser no tolerante a fallos, Kafka es la mejor opción. 

En caso de fallo de un nodo, Kafka implementa mecanismos de reorganización de la actividad y de replicación de datos para retomar el estado del sistema en el punto de fallo. Incluso, si hubiera un fallo total del sistema, Kafka podría recuperar el estado del mismo a partir de la información persistente.

Por otro lado, si el número de usuarios del sistema creciera exponencialmente, Kafka podría escalar horizontalmente para manejar la carga sin problemas.

## Despliegue de Kafka

En estas fases tempranas de desarrollo, se ha elegido una configuración basada en Docker Compose que permite levantar un clúster básico de Kafka compuesto por 3 controladores y 3 brokers. Esta configuración es adecuada para pruebas y desarrollo inicial, pero no debe utilizarse en un entorno de producción sin adaptaciones adicionales para mejorar la resiliencia, seguridad y capacidad de escalado.

### Código fuente: `compose.yaml`

```yaml
services:
  controller-1:
    image: apache/kafka:latest
    container_name: controller-1
    environment:
      KAFKA_NODE_ID: 1
      KAFKA_PROCESS_ROLES: controller
      KAFKA_LISTENERS: CONTROLLER://:9093
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0

  controller-2:
    image: apache/kafka:latest
    container_name: controller-2
    environment:
      KAFKA_NODE_ID: 2
      KAFKA_PROCESS_ROLES: controller
      KAFKA_LISTENERS: CONTROLLER://:9093
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0

  controller-3:
    image: apache/kafka:latest
    container_name: controller-3
    environment:
      KAFKA_NODE_ID: 3
      KAFKA_PROCESS_ROLES: controller
      KAFKA_LISTENERS: CONTROLLER://:9093
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0

  broker-1:
    image: apache/kafka:latest
    container_name: broker-1
    ports:
      - 29092:9092
    environment:
      KAFKA_NODE_ID: 4
      KAFKA_PROCESS_ROLES: broker
      KAFKA_LISTENERS: "PLAINTEXT://:19092,PLAINTEXT_HOST://:9092"
      KAFKA_ADVERTISED_LISTENERS: "PLAINTEXT://broker-1:19092,PLAINTEXT_HOST://localhost:29092"
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0
    depends_on:
      - controller-1
      - controller-2
      - controller-3

  broker-2:
    image: apache/kafka:latest
    container_name: broker-2
    ports:
      - 39092:9092
    environment:
      KAFKA_NODE_ID: 5
      KAFKA_PROCESS_ROLES: broker
      KAFKA_LISTENERS: "PLAINTEXT://:19092,PLAINTEXT_HOST://:9092"
      KAFKA_ADVERTISED_LISTENERS: "PLAINTEXT://broker-2:19092,PLAINTEXT_HOST://localhost:39092"
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0
    depends_on:
      - controller-1
      - controller-2
      - controller-3

  broker-3:
    image: apache/kafka:latest
    container_name: broker-3
    ports:
      - 49092:9092
    environment:
      KAFKA_NODE_ID: 6
      KAFKA_PROCESS_ROLES: broker
      KAFKA_LISTENERS: "PLAINTEXT://:19092,PLAINTEXT_HOST://:9092"
      KAFKA_ADVERTISED_LISTENERS: "PLAINTEXT://broker-3:19092,PLAINTEXT_HOST://localhost:49092"
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_CONTROLLER_LISTENER_NAMES: CONTROLLER
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_CONTROLLER_QUORUM_VOTERS: 1@controller-1:9093,2@controller-2:9093,3@controller-3:9093
      KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0
    depends_on:
      - controller-1
      - controller-2
      - controller-3
```

### Servicios desplegados

1. **Controladores (`controller-1`, `controller-2`, `controller-3`)**:
   - **Función**: Los controladores son responsables de la coordinación del clúster de Kafka. Se encargan de la asignación de particiones a los brokers y la elección de líderes para las particiones.
   - **Comunicación**: Los controladores se comunican entre ellos para mantener un cuórum y tomar decisiones coordinadas sobre el estado del clúster. Esta comunicación se realiza a través del puerto 9093, definido en la configuración como el listener `CONTROLLER`.
   - **Organización**: Cada controlador se identifica con un `KAFKA_NODE_ID` único y se especifica en la configuración `KAFKA_CONTROLLER_QUORUM_VOTERS`, que lista todos los controladores y sus puertos. Esta configuración asegura que los controladores sepan cómo comunicarse entre ellos para mantener la coherencia del clúster.

_Nota_: Un 'cuórum', según la RAE, se define como el "número de individuos necesario para que un cuerpo deliberante tome ciertos acuerdos". En el contexto de Kafka, el cuórum de controladores es esencial para garantizar que el clúster pueda tomar decisiones de forma distribuida y tolerante a fallos.

2. **Brokers (`broker-1`, `broker-2`, `broker-3`)**:
   - **Función**: Los brokers son los servidores que almacenan los datos de Kafka. Reciben mensajes de los productores y sirven estos mensajes a los consumidores. Cada broker puede gestionar una o más particiones de un tópico.
   - **Comunicación**:
     - **Inter-Broker**: Los brokers se comunican entre ellos para replicar datos y coordinarse. Esta comunicación se realiza a través del listener `PLAINTEXT`, que usa el puerto 19092 dentro de la red de Docker.
     - **Conexión con Clientes Externos**: Los brokers están configurados con listeners adicionales (`PLAINTEXT_HOST`) que exponen los puertos 29092, 39092, y 49092 en el host, permitiendo que clientes externos al contenedor (como productores y consumidores fuera de Docker) se conecten a Kafka.
   - **Organización**: Cada broker también tiene un `KAFKA_NODE_ID` único y se comunica con los controladores para recibir la asignación de particiones y sincronizarse en caso de fallos.

### Detalle de las opciones especificadas

- **`KAFKA_NODE_ID`**: Establece un identificador único para cada nodo (controlador o broker) en el clúster, necesario para que Kafka mantenga un seguimiento preciso de las responsabilidades de cada nodo.
  
- **`KAFKA_PROCESS_ROLES`**: Define si el nodo actúa como controlador, broker o ambos. En esta configuración, se han separado los roles de controlador y broker, con nodos dedicados para cada función.
  
- **`KAFKA_LISTENERS` y `KAFKA_ADVERTISED_LISTENERS`**: Configura los endpoints de red que Kafka utiliza para la comunicación. `KAFKA_LISTENERS` define los puertos y protocolos que los brokers y controladores escuchan, mientras que `KAFKA_ADVERTISED_LISTENERS` expone esos endpoints al mundo exterior, lo que es esencial para que los clientes externos puedan conectarse.
  
- **`KAFKA_CONTROLLER_QUORUM_VOTERS`**: Lista los nodos que participan en el cuórum de controladores, asegurando que el clúster pueda tomar decisiones de forma distribuida y tolerante a fallos.
  
- **`KAFKA_INTER_BROKER_LISTENER_NAME`**: Especifica qué listener se utilizará para la comunicación interna entre brokers, que en este caso es `PLAINTEXT`.
  
- **`KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS`**: Controla el retraso inicial antes de que los grupos de consumidores comiencen a reequilibrarse. Se ha establecido en 0 para minimizar el tiempo de reequilibrio en un entorno de desarrollo.

### Instrucciones de despliegue y ejemplo de uso
1. En el directorio donde se encuentra el archivo `compose.yaml`, ejecutar el siguiente comando para levantar el clúster de Kafka:
```bash
docker-compose up -d
```
2. Para verificar que los servicios se han levantado correctamente, ejecutar:
```bash
docker-compose ps
```
Debería mostrar los servicios `controller-1`, `controller-2`, `controller-3`, `broker-1`, `broker-2`, y `broker-3` con estado `Up`.

3. Abra una terminal en el contenedor de `broker-1` para interactuar con Kafka. Ejecute:
```bash
docker exec --workdir /opt/kafka/bin/ -it broker-1 sh
```

4. Cree un tópico de prueba llamado `ejemplo` con 3 particiones y un factor de replicación de 2:
```bash
./kafka-topics.sh --bootstrap-server broker-1:19092,broker-2:19092,broker-3:19092 --create --topic ejemplo --partitions 3 --replication-factor 2
```

5. Publique un mensaje en el tópico `ejemplo`:
```bash
./kafka-console-producer.sh --bootstrap-server broker-1:19092,broker-2:19092,broker-3:19092 --topic ejemplo
```
Introduzca tantos mensajes como quiera, presionando `Enter` después de cada línea introducida. Cuando termine de introducir mensajes, presione `Ctrl+C` para salir del productor.

6. Consuma los mensajes del tópico `ejemplo`:
```bash
./kafka-console-consumer.sh --bootstrap-server broker-1:19092,broker-2:19092,broker-3:19092 --topic ejemplo --from-beginning
```
--- 
# API de Kafka

Existen 4 APIs principales en Kafka:
1. **Producer API**: Permite a las aplicaciones publicar flujos de registros en uno o más tópicos de Kafka.
2. **Consumer API**: Permite a las aplicaciones suscribirse a uno o más tópicos y procesar los flujos de registros producidos.
3. **Streams API**: Permite a las aplicaciones actuar como procesadores de flujos de registros, consumiendo de uno o más tópicos de entrada y produciendo flujos de registros a uno o más tópicos de salida.
4. **Connector API**: Permite a las aplicaciones conectarse a sistemas externos y mover datos dentro y fuera de Kafka.
