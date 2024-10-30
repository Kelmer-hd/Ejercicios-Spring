# Sistema de Gestión de Biblioteca - Nivel Básico

## Descripción General
Desarrollar un sistema básico para gestionar los libros de una biblioteca pequeña. Este ejercicio te ayudará a familiarizarte con los conceptos básicos de Spring Boot, JPA y REST APIs.

## Requisitos Funcionales

### Gestión de Libros
- Crear un nuevo libro
- Obtener un libro por su ID
- Listar todos los libros
- Actualizar información de un libro
- Eliminar un libro

### Modelo de Datos
El libro debe contener los siguientes campos:
- ID (generado automáticamente)
- Título
- Autor
- ISBN
- Año de publicación

## Requisitos Técnicos

### Tecnologías a utilizar
- Spring Boot
- Spring Data JPA
- Base de datos H2 (para desarrollo)
- Maven

### Estructura del proyecto
- Implementar arquitectura en capas (Controller, Service, Repository)
- Usar DTOs para la transferencia de datos

## Endpoints a implementar

```
GET /api/libros - Obtener todos los libros
GET /api/libros/{id} - Obtener un libro por ID
POST /api/libros - Crear un nuevo libro
PUT /api/libros/{id} - Actualizar un libro existente
DELETE /api/libros/{id} - Eliminar un libro
```

## Validaciones Requeridas
- El título no puede estar vacío
- El ISBN debe ser único
- El año de publicación no puede ser futuro

## Criterios de Aceptación
1. Todos los endpoints deben devolver los códigos HTTP apropiados
2. Implementar manejo básico de excepciones
3. La aplicación debe iniciar correctamente
4. Los datos deben persistir en la base de datos
5. Las respuestas deben estar en formato JSON

## Retos Adicionales (Opcionales)
- Agregar paginación al listado de libros
- Implementar búsqueda de libros por título o autor
- Agregar documentación con Swagger
