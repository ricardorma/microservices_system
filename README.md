
# Sistema básico de microservicios - Gestión de inventario

En este proyecto se ha implementado un sistema de Gestión de inventario basado en microservicios, donde se distinguen los siguientes servicios:

* Producto
* Inventario
* Ordenes


## Tech Stack

**Code language:** Java

**Deploy tools:** Github, docker

**BBDD used:** MySQL, Postgresql

**Framework:** Springboot


## Arquitectura del sistema
![diagram-export-6-5-2024-11_49_12](https://github.com/ricardorma/microservices_system/assets/45419870/e4a3c76e-8c0d-4f59-9b55-d989703c6cb6)



## API Reference

### Microservicio products

#### Get all products

```http
  GET /api/product
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. The api key |

#### Add a new product

```http
  Post /api/product
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `productRequest`      | `ProductRequest` | **Required**. Product to add

##### Parámetros incluidos dentro del parámetro productRequest:

| Parameter | Type     |
| :-------- | :------- |
| `sku`      | `String` 
| `name`      | `String` |
| `description`      | `String` 
| `price`      | `Double` 
| `status`      | `boolean` 




