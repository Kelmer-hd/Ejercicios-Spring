# Ejercicio 2: Sistema de Pedidos de Comida Online 🍕

## Objetivo
Desarrollar una API RESTful para gestionar pedidos de comida online, similar a una aplicación de delivery.

## Requisitos Funcionales

### Entidades Principales

1. Restaurante (Restaurant)
    - ID (Long)
    - Nombre (String)
    - Dirección (String)
    - Teléfono (String)
    - Categoría (Enum: ITALIANA, MEXICANA, CHINA, etc.)
    - Horario de apertura (LocalTime)
    - Horario de cierre (LocalTime)
    - Estado (Enum: ABIERTO, CERRADO, TEMPORALMENTE_CERRADO)
    - Calificación promedio (Double)

2. Producto (Product)
    - ID (Long)
    - RestauranteID (Long)
    - Nombre (String)
    - Descripción (String)
    - Precio (BigDecimal)
    - Categoría (Enum: ENTRADA, PLATO_PRINCIPAL, POSTRE, BEBIDA)
    - Disponibilidad (Boolean)
    - Tiempo estimado de preparación (Integer, en minutos)

3. Cliente (Customer)
    - ID (Long)
    - Nombre (String)
    - Email (String)
    - Teléfono (String)
    - Direcciones de entrega (List\<String>)
    - Fecha de registro (LocalDateTime)

4. Pedido (Order)
    - ID (Long)
    - ClienteID (Long)
    - RestauranteID (Long)
    - Items del pedido (List\<OrderItem>)
    - Fecha del pedido (LocalDateTime)
    - Estado (Enum: PENDIENTE, CONFIRMADO, EN_PREPARACION, EN_CAMINO, ENTREGADO, CANCELADO)
    - Dirección de entrega (String)
    - Total (BigDecimal)
    - Tiempo estimado de entrega (Integer, en minutos)
    - Método de pago (Enum: TARJETA, EFECTIVO)

5. Item del Pedido (OrderItem)
    - ID (Long)
    - PedidoID (Long)
    - ProductoID (Long)
    - Cantidad (Integer)
    - Precio unitario (BigDecimal)
    - Subtotal (BigDecimal)
    - Notas especiales (String)

## Endpoints a Implementar

### Restaurantes
- GET `/api/restaurants` - Listar restaurantes (con filtros por categoría y estado)
- GET `/api/restaurants/{id}` - Obtener detalles de un restaurante
- GET `/api/restaurants/{id}/menu` - Obtener menú del restaurante
- POST `/api/restaurants` - Registrar nuevo restaurante
- PUT `/api/restaurants/{id}` - Actualizar información del restaurante
- PUT `/api/restaurants/{id}/status` - Actualizar estado del restaurante

### Productos
- GET `/api/restaurants/{restaurantId}/products` - Listar productos por restaurante
- POST `/api/restaurants/{restaurantId}/products` - Agregar producto al menú
- PUT `/api/restaurants/{restaurantId}/products/{id}` - Actualizar producto
- DELETE `/api/restaurants/{restaurantId}/products/{id}` - Eliminar producto

### Clientes
- POST `/api/customers` - Registrar cliente
- GET `/api/customers/{id}` - Obtener información del cliente
- PUT `/api/customers/{id}` - Actualizar información del cliente
- GET `/api/customers/{id}/orders` - Obtener historial de pedidos

### Pedidos
- POST `/api/orders` - Crear nuevo pedido
- GET `/api/orders/{id}` - Obtener detalles del pedido
- PUT `/api/orders/{id}/status` - Actualizar estado del pedido
- GET `/api/restaurants/{restaurantId}/orders` - Listar pedidos por restaurante

## Requisitos Técnicos

### Obligatorios
1. Implementar Spring Boot 3.x
2. Usar PostgreSQL como base de datos
3. Implementar Spring Security con JWT para autenticación
4. Utilizar Spring Data JPA con relaciones entre entidades
5. Implementar DTOs para la transferencia de datos
6. Usar Flyway o Liquibase para migraciones de base de datos
7. Implementar manejo global de excepciones
8. Agregar validaciones con Spring Validation
9. Documentar la API con OpenAPI 3.0

### Reglas de Negocio
1. Un restaurante solo puede recibir pedidos durante su horario de apertura
2. El tiempo estimado de entrega debe calcularse basado en:
    - Tiempo de preparación de los productos
    - Distancia al punto de entrega (simulada)
    - Cantidad de pedidos activos
3. Un pedido no puede modificarse después de estar EN_PREPARACION
4. Implementar descuentos por cantidad en los pedidos
5. Validar stock de productos al realizar pedidos

## Puntos Extra (Opcionales)
1. Implementar sistema de notificaciones (simular envío de emails)
2. Agregar sistema de calificaciones para restaurantes y productos
3. Implementar búsqueda full-text de productos
4. Agregar caché con Redis
5. Implementar websockets para actualizaciones en tiempo real
6. Agregar tests de integración

## Estructura de Proyecto Sugerida
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── fooddelivery/
│   │           ├── FoodDeliveryApplication.java
│   │           ├── config/
│   │           ├── controllers/
│   │           ├── models/
│   │           ├── repositories/
│   │           ├── services/
│   │           ├── security/
│   │           ├── exceptions/
│   │           ├── dtos/
│   │           └── utils/
│   └── resources/
│       ├── application.properties
│       └── db/migration/
└── test/
    └── java/
```

## Entregables Esperados
1. Código fuente en repositorio Git
2. README detallado con:
    - Instrucciones de configuración
    - Guía de despliegue
    - Documentación de la API
3. Colección de Postman
4. Diagrama de la base de datos
5. Scripts de migración

¿Te gustaría comenzar con este ejercicio? Puedo ayudarte si tienes dudas específicas sobre alguna parte.