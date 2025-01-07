# Sistema de Gestión de Restaurante

Desarrolla una API REST para gestionar los pedidos de un restaurante con las siguientes características:

**Entidades necesarias:**
- Plato (id, nombre, descripción, precio, categoría, tiempo de preparación, disponible)
- Mesa (id, número, capacidad, estado)
- Pedido (id, mesa, lista de platos, estado, fecha, total)
- Empleado (id, nombre, rol, turno)

**Funcionalidades requeridas:**
1. CRUD completo para platos y empleados
2. Sistema de pedidos que debe:
    - Permitir crear pedidos asociados a una mesa
    - Calcular el tiempo estimado de preparación total
    - Calcular el total del pedido con impuestos
    - Manejar estados del pedido (recibido, en preparación, listo, entregado)

3. Endpoints específicos para:
    - Consultar mesas disponibles
    - Obtener el historial de pedidos por mesa
    - Generar reporte de ventas por día/semana/mes
    - Listar platos más vendidos
    - Cambiar el estado de las mesas

**Requisitos técnicos:**
- Implementar arquitectura en capas (controller, service, repository)
- Usar DTOs para las peticiones y respuestas
- Implementar manejo de errores global
- Incluir paginación en las consultas de listados
- Agregar logs para operaciones importantes
- Documentar con Swagger/OpenAPI
