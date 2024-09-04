# Microservicios en SaludConecta

## 1. ¿Qué son los microservicios?

Los **microservicios** son un patrón arquitectónico en el que las aplicaciones se dividen en pequeños servicios independientes, cada uno responsable de una única función de negocio. Cada microservicio se despliega de manera autónoma y se comunica con otros servicios a través de APIs bien definidas. Esto permite que cada microservicio sea desarrollado, actualizado y escalado por separado.

## 2. ¿Qué ventajas ofrecen frente a las arquitecturas monolíticas?

En una **arquitectura monolítica**, todas las funcionalidades de una aplicación están unidas en una única entidad. Esto puede ser fácil de manejar en las primeras etapas, pero a medida que la aplicación crece, surgen limitaciones:

- **Desplegar actualizaciones es riesgoso**: Un cambio en una parte del sistema puede afectar a toda la aplicación, lo que lleva a que un fallo en un componente impacte el sistema completo.
- **Escalabilidad limitada**: Si una parte específica de la aplicación necesita más recursos, no es posible escalar solo esa parte; es necesario escalar toda la aplicación.
- **Tecnologías y lenguajes rígidos**: Estás limitado a las decisiones tecnológicas tomadas al inicio del desarrollo, lo que puede dificultar la incorporación de nuevas tecnologías.

Con una arquitectura de **microservicios**, estos problemas se resuelven al dividir la aplicación en partes independientes:

- **Despliegue independiente**: Cada servicio se puede actualizar sin necesidad de afectar a los demás. Esto reduce el riesgo de errores en el sistema global.
- **Escalabilidad independiente**: Solo los servicios que lo necesiten se pueden escalar, lo que optimiza los recursos y mejora la eficiencia.
- **Flexibilidad tecnológica**: Cada equipo puede elegir la tecnología más adecuada para su servicio, lo que permite adaptarse a nuevas herramientas o lenguajes.

## 3. Otras ventajas de los microservicios

Además de las mejoras frente a las arquitecturas monolíticas, los microservicios ofrecen otros beneficios:

- **Agilidad**: Los equipos pueden trabajar de forma autónoma en diferentes microservicios, lo que acelera el ciclo de desarrollo y permite iteraciones rápidas.
- **Resiliencia**: Si un microservicio falla, el resto de la aplicación sigue funcionando. Esto mejora la disponibilidad general del sistema.
- **Reutilización de código**: Los microservicios pueden ser reutilizados en otras aplicaciones o contextos, facilitando la creación de nuevas funcionalidades sin necesidad de reescribir código.
- **Mantenimiento simplificado**: Al ser servicios más pequeños y especializados, el código es más fácil de entender y mantener.
- **Mejor soporte para DevOps**: Facilitan la integración continua y el despliegue continuo (CI/CD), lo que permite probar e implementar nuevos cambios de forma más rápida y segura.

## 4. ¿Por qué es ideal para este proyecto y qué aspectos se benefician?

En **SaludConecta**, la arquitectura de microservicios es ideal porque:

- **Dominios claramente definidos**: SaludConecta tiene distintos dominios (Pacientes, Personal, Citas, Recursos, etc.), y cada uno de ellos puede representarse como un microservicio. Esto mejora la modularidad y facilita la gestión de cada dominio de forma independiente.
- **Escalabilidad**: Servicios como el de gestión de citas o el de asignación de recursos podrían necesitar más capacidad en momentos específicos. Los microservicios permiten escalar solo estos componentes cuando sea necesario.
- **Despliegue continuo**: Los microservicios permiten actualizar y desplegar nuevas funcionalidades sin interrumpir el servicio completo, solo el microservicio que contiene la funcionalidad a actualizar en cuestión.
- **Resiliencia y disponibilidad**: Si un microservicio falla (por ejemplo, el sistema de gestión de médicos), el sistema de citas o pacientes puede seguir funcionando sin problemas. Esto asegura un alto nivel de disponibilidad, lo cual es crucial en un entorno hospitalario.
  
## Referencias

- [¿Qué son los microservicios? - IBM Technology](https://www.youtube.com/watch?v=CdBtNQZH8a4&t=256s)
- [Microservices.io](https://microservices.io/)
- [What are Microservices? | AWS](https://aws.amazon.com/es/microservices/)
- [What Is Microservices Architecture? - Google Cloud](https://cloud.google.com/learn/what-is-microservices-architecture)