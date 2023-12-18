create database jpa;
use jpa;
CREATE TABLE Customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    balance DOUBLE NOT NULL
);

CREATE TABLE CreatedOrder (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    creationDateTimeMillis BIGINT,
    amount DOUBLE,
    productInfo VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);


