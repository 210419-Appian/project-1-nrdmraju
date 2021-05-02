
DROP TABLE roles;

CREATE TABLE roles (
	role_id INTEGER PRIMARY KEY,
	role_description VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO roles(role_id, role_description) 
	VALUES (1, 'Admin'),
			(2, 'Employee'),
			(3, 'Standard'),
			(4, 'Premium');

DROP TABLE account_status;

CREATE TABLE account_status(
status_id INTEGER PRIMARY KEY,
status VARCHAR(15) NOT NULL UNIQUE
);

INSERT INTO account_status(status_id, status) 
	VALUES (1, 'Pending'),
			(2, 'Closed'),
			(3, 'Open'),
			(4, 'Denied');


DROP TABLE account_types;

CREATE TABLE account_types(
type_id INTEGER PRIMARY KEY,
type_description VARCHAR(15) NOT NULL UNIQUE 
);

INSERT INTO account_types (type_id, type_description) 
	VALUES (1, 'Checking'),
			(2, 'Savings');


DROP TABLE users;

CREATE TABLE users (
	user_id integer PRIMARY KEY,
	username varchar(30) NOT NULL,
	user_password VARCHAR(30) NOT NULL, 
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(35) NOT NULL,
	user_role integer REFERENCES roles(role_id)
	
);

DROP TABLE account;
DROP TABLE accounts;

CREATE TABLE accounts(
 accountId INTEGER PRIMARY KEY, 
 balance INTEGER NOT NULL,
 account_status INTEGER REFERENCES account_status(status_id),
 account_type INTEGER REFERENCES account_types(type_id),
 user_id INTEGER REFERENCES users(user_id)
);

