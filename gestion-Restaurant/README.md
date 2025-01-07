# Sistema de Gestión de Restaurant:

Requerimientos:
1. Gestionar múltiples entidades relacionadas:

    - Plato
        - ID
        - Nombre
        - Descripción
        - Precio
        - Categoría (ENTRADA, PRINCIPAL, POSTRE, BEBIDA)
        - Tiempo de preparación (minutos)
        - Estado (DISPONIBLE, NO_DISPONIBLE)
        - Lista de ingredientes necesarios

    - Ingrediente
        - ID
        - Nombre
        - Stock actual
        - Unidad de medida (KG, UNIDAD, LITRO)
        - Stock mínimo
        - Stock máximo

    - Mesa
        - ID
        - Número de mesa
        - Capacidad
        - Estado (LIBRE, OCUPADA, RESERVADA)

    - Orden
        - ID
        - Mesa
        - Lista de platos ordenados
        - Estado (PENDIENTE, EN_PREPARACION, LISTA, ENTREGADA, PAGADA)
        - Fecha y hora
        - Total
        - Método de pago
        - Notas especiales

2. Funcionalidades Avanzadas:
    - CRUD para todas las entidades
    - Sistema de reservas de mesas
    - Control de inventario automático:
        * Reducir stock cuando se prepara un plato
        * Alertas cuando el stock está bajo el mínimo
    - Endpoint para cambiar el estado de las órdenes
    - Cálculo automático del total de la orden
    - Reporte de ventas por día/semana/mes
    - Platos más vendidos
    - Tiempo promedio de preparación por plato

3. Validaciones y Reglas de Negocio:
    - No se puede crear una orden para una mesa ocupada
    - Validar stock suficiente antes de aceptar una orden
    - No permitir ordenar platos no disponibles
    - Validar capacidad de mesa al hacer reserva
    - No permitir reservas duplicadas para la misma fecha/hora/mesa
    - Actualizar automáticamente el estado de la mesa según las órdenes

4. Características Técnicas Adicionales:
    - Implementar paginación para las listas
    - Filtros de búsqueda avanzados
    - Manejo de transacciones
    - Caché para los platos más consultados
    - Logging de operaciones importantes
    - Programación de tareas para reportes diarios
    - Documentación con Swagger

Este ejercicio te ayudará a practicar:
- Relaciones complejas entre entidades
- Lógica de negocio avanzada
- Manejo de transacciones
- Programación de tareas (@Scheduled)
- Caché
- Generación de reportes
- Documentación de API

¿Te gustaría intentar este ejercicio más complejo? Cuando lo completes, podemos pasar a uno que incluya integración con servicios externos, seguridad, y funcionalidades en tiempo real.