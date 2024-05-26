# 🌐 Sistema Básico de Microservicios - Gestión de Inventario

En este proyecto se ha implementado un sistema de Gestión de Inventario basado en microservicios, donde se distinguen los siguientes servicios:

- 📦 **Producto**
- 📊 **Inventario**
- 🛒 **Órdenes**

## 🚀 Tech Stack

### 💻 Lenguaje de Programación
- Java

### 🛠️ Despliegue y Control de Versiones
- GitHub
- Docker

### 🗄️ Bases de Datos
- MySQL
- PostgreSQL

### 📬 Sistema de Notificaciones
- Kafka

### 🎨 Framework
- Spring Boot

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

3. Los servicios estarán disponibles en los siguientes puertos:

    - **Producto:** `http://localhost:8081`
    - **Inventario:** `http://localhost:8082`
    - **Órdenes:** `http://localhost:8083`

---

## 🛠️ Mantenimiento

Para detener y eliminar los contenedores, ejecuta:

```sh
docker-compose down
```

## 📞 Contacto

Creador: [Ricardo Rodríguez Mateos-Aparicio](https://github.com/ricardorma)  
