# 🌐 Sistema Básico de Microservicios - Gestión de Inventario

En este proyecto se ha implementado un sistema de Gestión de Inventario basado en microservicios, donde se distinguen los siguientes servicios:

- 📦 **Producto**
- 📊 **Inventario**
- 🛒 **Órdenes**
- 🌀 **Servidor de Eureka**
- 🌐 **API Gateway**

## 🚀 Tech Stack

### 💻 Framework y Lenguaje de Programación
- Spring Boot
- Java

### 🛠️ Despliegue y Control de Versiones
- GitHub
- Docker

### 🗄️ Bases de Datos
- MySQL
- PostgreSQL

### 📬 Sistema de Notificaciones
- Kafka

### 🔍 Pruebas
- Postman

### 🔑 Control de Acceso
- Keycloak

---

## 📂 Estructura del Proyecto
![diagram-export-26-5-2024-14_05_17](https://github.com/ricardorma/microservices_system/assets/45419870/0a79152e-b3a6-4bf5-8077-132a0b68d18e)

## 🔧 Configuración y Despliegue

### Prerrequisitos

Asegúrate de tener instalados los siguientes programas:

- Docker
- Docker Compose
- Java 11 o superior

### Instalación

1. Clona este repositorio:

    ```sh
    git clone https://github.com/tu-usuario/sistema-gestion-inventario.git
    cd sistema-gestion-inventario
    ```

2. Construye y levanta los contenedores:

    ```sh
    docker-compose up --build
    ```
3. Configura el servidor de keycloak para poder tener acceso a los microservicios y poder realizar peticiones.

4. Los servicios estarán disponibles a través del puerto `http://localhost:8080` del api Gateway


---

## 🛠️ Mantenimiento

Para detener y eliminar los contenedores, ejecuta:

```sh
docker-compose down
```

## 📞 Contacto

Creador: [Ricardo Rodríguez Mateos-Aparicio](https://github.com/ricardorma)  
