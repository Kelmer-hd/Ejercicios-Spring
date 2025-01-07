# Proyecto Integrador con Spring

## Especificaciones

Este proyecto integrador tiene como objetivo desarrollar una aplicación web utilizando el framework Spring. La aplicación estará enfocada en un sistema de gestión de encuestas para una empresa.

## Requerimientos Funcionales

1. **Módulo de usuarios**:
    - Registro de nuevos usuarios (nombre, apellido, correo electrónico, contraseña)
    - Inicio de sesión de usuarios
    - Actualización de perfil de usuario
    - Recuperación de contraseña

2. **Módulo de encuestas**:
    - Creación de nuevas encuestas (título, descripción, fecha de inicio y fin)
    - Listado de encuestas disponibles
    - Detalle de una encuesta específica
    - Edición y eliminación de encuestas (solo para usuarios administradores)

3. **Módulo de preguntas**:
    - Creación de preguntas para una encuesta (título, tipo de pregunta: opción múltiple, texto, numérica, etc.)
    - Orden de preguntas dentro de una encuesta
    - Edición y eliminación de preguntas (solo para usuarios administradores)

4. **Módulo de respuestas**:
    - Registro de respuestas de los usuarios a las preguntas de una encuesta
    - Visualización de resultados de una encuesta (resumen de respuestas por pregunta)
    - Exportación de resultados de una encuesta a un archivo CSV

5. **Roles de usuario**:
    - Usuario administrador: puede crear, editar y eliminar encuestas, preguntas y ver resultados
    - Usuario regular: puede responder a las encuestas disponibles y ver los resultados de las encuestas en las que ha participado

6. **Otras funcionalidades**:
    - Sistema de notificaciones por correo electrónico a los usuarios sobre encuestas próximas a vencer
    - Dashboard con estadísticas generales del sistema (número de usuarios, encuestas, respuestas, etc.)

## Tecnologías a Utilizar

- Spring Boot (versión 2.7.x o superior)
- Spring Security para autenticación y autorización
- Spring Data JPA para la capa de persistencia
- MySQL o PostgreSQL como base de datos
- Thymeleaf como motor de plantillas
- Bootstrap o un framework CSS similar para el diseño de la interfaz de usuario

## Requisitos No Funcionales

- Pruebas unitarias y de integración utilizando JUnit y Mockito
- Documentación del código siguiendo las mejores prácticas
- Despliegue de la aplicación en un entorno de producción (por ejemplo, Heroku, AWS, etc.)