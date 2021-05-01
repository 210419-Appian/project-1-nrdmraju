
DROP TABLE roles;

CREATE TABLE roles (
	role_id INTEGER PRIMARY KEY,
	role_description VARCHAR(20) NOT NULL UNIQUE
);

DROP TABLE account_status;

CREATE TABLE account_status(
status_id INTEGER PRIMARY KEY,
status VARCHAR(15) NOT NULL UNIQUE
);

DROP TABLE account_types;

CREATE TABLE account_types(
type_id INTEGER PRIMARY KEY,
type_description VARCHAR(15) NOT NULL UNIQUE 
);






DROP TABLE users;

CREATE TABLE users (
	user_id integer PRIMARY KEY,
	username varchar(30) NOT NULL,
	user_password VARCHAR(30) NOT NULL, 
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(35) NOT NULL,
	user_role VARCHAR(20)
);

