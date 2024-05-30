## Endpoints

### Clientes

- [x] Obtener un cliente por ID: GET /client/{clientId}
- [x] Agregar un nuevo cliente: POST /client
- [x] Actualizar un cliente existente: PUT /client/{clientId}
- [x] Eliminar un cliente: DELETE /client/{clientId}

### Productos

- [x] Obtener un producto por ID: GET /product/{productId}
- [x] Agregar un nuevo producto: POST /product
- [x] Actualizar un producto existente: PUT /product/{productId}
- [x] Eliminar un producto: DELETE /product/{productId}

### Pedidos

- [x] Obtener todos los pedidos: GET /orders
- [x] Obtener un pedido por ID: GET /orders/{id}
- [x] Agregar un nuevo pedido: POST /orders
- [x] Actualizar un pedido existente: PUT /orders/{id}
- [x] Eliminar un pedido: DELETE /orders/{id}


## Flyway
### V1__Create_Client_Table.sql

create table client (
	id SERIAL,
	name VARCHAR(255),
	age INTEGER,
	address VARCHAR(255),
	constraint client_pk primary key(id)
);

create table product (
	id SERIAL,
	name VARCHAR(255),
	price DOUBLE PRECISION,
	brand VARCHAR(255),
	constraint product_pk primary key(id)
);


## Tests JUNIT5

![image](https://github.com/lug031/crudSpring/assets/53354972/12497292-4f24-4dba-9b2a-430a5fc30ba2)


## Validaciones de entrada

Client

![image](https://github.com/lug031/crudSpring/assets/53354972/b908a6cc-91e2-4d39-9a76-9ab50d8833a2)

![image](https://github.com/lug031/crudSpring/assets/53354972/f5942655-da5f-4215-935b-a3e9ab587ed3)


## Manejo de excepciones

![image](https://github.com/lug031/crudSpring/assets/53354972/aff7866e-0ef0-4d79-92a6-48dfe6717e49)

![image](https://github.com/lug031/crudSpring/assets/53354972/83b11aba-d77b-4443-825f-e3f3c91b55f0)

![image](https://github.com/lug031/crudSpring/assets/53354972/bde87e75-5422-42ef-b7a1-697d3bd4e525)


## Collection in Postman

[springboot.postman_collection.json](https://github.com/lug031/crudSpringApp/files/15505949/springboot.postman_collection.json)
