
# Sistema básico de microservicios - Gestión de inventario

En este proyecto se ha implementado un sistema de Gestión de inventario basado en microservicios, donde se distinguen los siguientes servicios:

* Producto
* Inventario
* Ordenes


## Tech Stack

**Code language:** Java

**Deploy tools:** Github, docker

**BBDD used:** MySQL, Postgresql

**Framework:**: Springboot


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



