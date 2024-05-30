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