# Sistema de Apoyo para Mascotas Saludables

Aplicación web desarrollada con **OpenXava** para gestionar un programa de apoyo económico destinado a mascotas saludables.
El sistema permite registrar mascotas, calcular su estado nutricional y determinar automáticamente el apoyo económico correspondiente según reglas de negocio definidas.

## Objetivo del Proyecto

Desarrollar una aplicación web transaccional que permita la gestión automatizada de un programa de apoyo económico para mascotas, garantizando la integridad de los datos y la correcta aplicación de las reglas de negocio basadas en el estado nutricional del animal.

## Tecnologías Utilizadas

* Java
* OpenXava
* Hibernate / JPA
* Base de datos relacional (HSQLDB / MySQL)
* Arquitectura MVC

## Arquitectura del Sistema

El sistema sigue una **arquitectura monolítica basada en MVC**:

* **Vista (Frontend):** Generada automáticamente por OpenXava mediante JavaScript y AJAX.
* **Modelo y Controlador (Backend):** Implementado en Java utilizando entidades de dominio con anotaciones de persistencia.
* **Persistencia:** Gestionada mediante Hibernate ORM y base de datos relacional.

## Funcionalidades Principales

* Registro de mascotas y dueños
* Gestión de catálogo de razas
* Cálculo automático del Índice de Masa del Animal (IMA)
* Determinación del estado nutricional:

  * Peso ideal
  * Bajo peso
  * Sobrepeso
  * Obesidad
* Cálculo automático del apoyo económico mensual
* Configuración de precios de alimento
* Administración de parámetros del sistema

## Modelo de Dominio

El sistema está compuesto por entidades transaccionales y entidades de referencia:

### Entidades Transaccionales

* Mascota
* Dueño

### Entidades de Catálogo

* Raza
* TablaConsumo
* TablaApoyo
* ConfiguracionPrecios

## Ejemplos de Casos de Uso

* Registrar mascota
* Consultar catálogo de razas
* Actualizar precios de servicios
* Validar índice de masa del animal
* Generar recomendaciones de salud

## Ejecución del Proyecto

1. Clonar el repositorio

```bash
git clone https://github.com/ErosRJ/openxava-sistema.git
```

2. Abrir el proyecto en IntelliJ IDEA o Eclipse

3. Ejecutar el proyecto mediante el servidor de aplicaciones configurado (Tomcat u otro compatible con Java EE)

## Despliegue

Para desplegar el sistema en un servidor web:

1. Compilar el proyecto usando Maven o Ant
2. Generar el archivo `.war`
3. Desplegar el archivo en un servidor como:

* Apache Tomcat
* WildFly
* Jetty

## Institución

Tecnológico Nacional de México
Instituto Tecnológico de Apizaco

Ingeniería en Tecnologías de la Información y Comunicaciones

## Autor

Proyecto desarrollado por:


* Eros Alejandro Rugerio Jiménez


## Estado del Proyecto

Proyecto académico desarrollado para la materia **Arquitecturas en el Desarrollo de Software**.
