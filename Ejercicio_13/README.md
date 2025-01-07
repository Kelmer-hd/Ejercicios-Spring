
# Primer ejercicio - Sistema de Gestión de Biblioteca:

Crea una aplicación Spring Boot para gestionar una biblioteca con los siguientes requerimientos:

Entidades necesarias:
- Libro (id, título, autor, ISBN, año de publicación, cantidad disponible)
- Usuario (id, nombre, email, número de membresía)
- Préstamo (id, id_libro, id_usuario, fecha_préstamo, fecha_devolución)

Funcionalidades requeridas:
1. CRUD completo para Libros y Usuarios
2. Endpoint para prestar un libro a un usuario
3. Endpoint para devolver un libro
4. Endpoint para listar todos los libros disponibles
5. Endpoint para buscar libros por autor o título

Requisitos técnicos:
- Usar Spring Data JPA para la persistencia
- Implementar manejo de excepciones personalizado
- Validaciones en las entidades usando Bean Validation
- Documentar la API usando Swagger
- Implementar al menos un test unitario para cada servicio

Restricciones de negocio:
- Un usuario no puede tener más de 3 libros prestados a la vez
- Un libro no se puede prestar si no hay copias disponibles
- El período de préstamo máximo es de 14 días

Este ejercicio te ayudará a practicar:
- Creación de APIs RESTful
- Manejo de relaciones entre entidades
- Validaciones
- Manejo de excepciones
- Testing
- Documentación de API
