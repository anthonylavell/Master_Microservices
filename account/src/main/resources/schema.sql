DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE customer (
 customer_id integer AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(100) NOT NULL,
 mobile_number VARCHAR(20) NOT NULL,
 create_dt date DEFAULT NULL
);

CREATE TABLE accounts (
 account_number int AUTO_INCREMENT PRIMARY KEY,
 customer_id int NOT NULL,
 loan_type VARCHAR(100) NOT NULL,
 branch_address VARCHAR(200) NOT NULL,
 create_dt date DEFAULT NULL
);