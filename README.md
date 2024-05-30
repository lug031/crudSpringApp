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

![image](https://github.com/lug031/crudSpringApp/assets/53354972/5cac51c7-c910-422b-a1ec-23ac65efe5f6)


## Validaciones de entrada

Client

![image](https://github.com/lug031/crudSpringApp/assets/53354972/8bca66cf-b250-44a5-b10f-7fc42b76f3cb)

![image](https://github.com/lug031/crudSpringApp/assets/53354972/dbd8c6d7-1237-4dc7-a10f-3ce24e977751)


## Manejo de excepciones

![image](https://github.com/lug031/crudSpringApp/assets/53354972/c180ef8e-0a26-4359-9afd-8c8ae84d1183)

![image](https://github.com/lug031/crudSpringApp/assets/53354972/dac2737f-78fa-4216-857f-43ed78bb034e)

![image](https://github.com/lug031/crudSpringApp/assets/53354972/fd19c75a-7f03-41a9-b2eb-55614df901a4)


## Collection in Postman

[springboot.postman_collection.json](https://github.com/lug031/crudSpringApp/files/15505949/springboot.postman_collection.json)
