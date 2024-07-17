# Prueba Tecnica
## Introducción

**Nota importante**

* La aplicación actualmente tiene un error crítico: no autentica correctamente los tokens de acceso.
* **Advertencia de seguridad**:  Entiendo que es una mala practica pero por motivos prácticos, el token de acceso y la URI dela base de datos estan disponibles en este repositorio.


Esta el la prueba tecnica presentada por Diego Alejandro Rodriguez Tamayo para el equipo de proteccionSA

## Requisitos previos

* Java 21
* Spring Boot 3.3.1
* Maven 3.9.0 o superior

## Instalación

1. Clona el repositorio: https://github.com/DiegoRdrz/PruebaTecnica
2. Cambia a la carpeta del proyecto: `cd PruebaTecnica`
3. Ejecuta el comando Maven para compilar y empaquetar la aplicación: `mvn clean package`

## Configuración

La aplicación utiliza las siguientes propiedades de configuración:

se bebe configurar un URI para una base de datos MONGO



La aplicación proporciona los siguientes endpoints:

* `POST /api/v1/auth/singin`: en este enpoint puedes loguearte y te retornara un token de acceso
* `POST /api/v1/auth/signup`: aqui te puedes registrar en la aplicacion
* `POST /api/v1/auth/refresk`: aqui eliminas la instancia del token anterior y generas uno nuevo
* `GET /api/v1/serie/`: aqui puedes obtener todas las series que se han registrado con su hora
* `POST /api/v1/serie/{time}`: aqui generas una nueva series
  
