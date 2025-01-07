# Proyecto Integrador con Spring

## Especificaciones del Proyecto

Este proyecto integrador tiene como objetivo desarrollar una aplicación web utilizando el framework Spring y Java. La aplicación será una plataforma de gestión de órdenes de compra para una empresa.

### Requisitos Funcionales

1. **Módulo de Autenticación y Autorización**:
    - Registro de nuevos usuarios (clientes y empleados)
    - Inicio de sesión de usuarios existentes
    - Asignación de roles y permisos (administrador, empleado, cliente)

2. **Módulo de Gestión de Órdenes de Compra**:
    - Creación de nuevas órdenes de compra por parte de los clientes
    - Visualización del estado de las órdenes (nueva, en proceso, enviada, entregada)
    - Actualización del estado de las órdenes por parte de los empleados
    - Búsqueda y filtrado de órdenes por diversos criterios (número de orden, estado, cliente, fecha, etc.)

3. **Módulo de Gestión de Productos**:
    - Registro de nuevos productos (nombre, descripción, categoría, precio, stock)
    - Actualización de la información de los productos
    - Visualización de la lista de productos disponibles

4. **Módulo de Gestión de Clientes**:
    - Registro de nuevos clientes (nombre, dirección, contacto)
    - Actualización de la información de los clientes
    - Visualización de la lista de clientes

5. **Módulo de Reportes**:
    - Generación de reportes de órdenes de compra (por estado, por cliente, por fecha)
    - Generación de reportes de inventario (productos, stock)
    - Generación de reportes de ventas (total, por producto, por cliente)

## Requisitos No Funcionales

1. **Tecnologías**:
    - Utilizar Spring Boot para el desarrollo del backend
    - Implementar una base de datos relacional (MySQL, PostgreSQL, etc.)
    - Utilizar Thymeleaf o Angular/React para el desarrollo del frontend

2. **Seguridad**:
    - Implementar autenticación y autorización utilizando Spring Security
    - Asegurar las comunicaciones utilizando HTTPS

3. **Rendimiento y Escalabilidad**:
    - Optimizar las consultas a la base de datos para mejorar el rendimiento
    - Implementar paginación en las vistas que muestran listas de datos

4. **Usabilidad**:
    - Diseñar una interfaz de usuario intuitiva y amigable
    - Implementar validaciones y mensajes de error claros para mejorar la experiencia del usuario

5. **Documentación**:
    - Generar documentación detallada del proyecto, incluyendo diagramas, especificaciones y guías de instalación y uso

## Entidades del Modelo de Datos

1. **Usuario**
    - ID
    - Nombre
    - Apellido
    - Correo electrónico
    - Contraseña
    - Rol (Administrador, Empleado, Cliente)

2. **Producto**
    - ID
    - Nombre
    - Descripción
    - Categoría
    - Precio
    - Stock

3. **OrdenDeCompra**
    - ID
    - Número de orden
    - Cliente (Usuario)
    - Productos (lista de Producto)
    - Fecha de creación
    - Fecha de envío
    - Fecha de entrega
    - Estado (Nueva, En proceso, Enviada, Entregada)

4. **Cliente** (extiende de Usuario)
    - Dirección
    - Teléfono

## Casos de Uso

1. **Autenticación y Autorización**:
    - Un usuario se registra en la plataforma
    - Un usuario inicia sesión en la aplicación
    - Un administrador asigna roles y permisos a los usuarios

2. **Gestión de Órdenes de Compra**:
    - Un cliente crea una nueva orden de compra
    - Un empleado actualiza el estado de una orden de compra
    - Un administrador o empleado busca y filtra órdenes de compra

3. **Gestión de Productos**:
    - Un administrador registra un nuevo producto
    - Un administrador actualiza la información de un producto
    - Un usuario (cliente o empleado) visualiza la lista de productos disponibles

4. **Gestión de Clientes**:
    - Un administrador registra un nuevo cliente
    - Un administrador actualiza la información de un cliente
    - Un usuario (administrador o empleado) visualiza la lista de clientes

5. **Generación de Reportes**:
    - Un usuario (administrador o empleado) genera un reporte de órdenes de compra
    - Un usuario (administrador o empleado) genera un reporte de inventario
    - Un usuario (administrador o empleado) genera un reporte de ventas

## Mockups y Diseño de la Interfaz de Usuario

Se incluyen los mockups y el diseño de la interfaz de usuario como parte de los entregables del proyecto.