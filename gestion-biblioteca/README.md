
# Sistema de Gestión de Biblioteca

## Requerimientos:

### Entidades principales:
- Libro (id, título, ISBN, año, copias disponibles)
- Autor (id, nombre, nacionalidad)
- Usuario (id, nombre, email, número de socio)
- Préstamo (id, fecha préstamo, fecha devolución)

### Funcionalidades:
- CRUD completo para todas las entidades
- Búsqueda de libros por título/autor/ISBN
- Registro de préstamos y devoluciones
- Control de copias disponibles
- Validación que un usuario no tenga más de 3 préstamos activos

###  Requisitos técnicos:
- Arquitectura por capas (controller, service, repository)
- Base de datos H2 o MySQL
- Manejo de excepciones personalizado
- Validaciones con Bean Validation
- Documentación con Swagger
- Tests unitarios
