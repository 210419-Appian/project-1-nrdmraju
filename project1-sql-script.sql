
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
	user_id SERIAL PRIMARY KEY,
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
 account_Id SERIAL PRIMARY KEY, 
 balance DOUBLE PRECISION NOT NULL,
 account_status INTEGER REFERENCES account_status(status_id),
 account_type INTEGER REFERENCES account_types(type_id),
 user_id INTEGER REFERENCES users(user_id)
);

INSERT INTO accounts(account_Id, balance, account_status, account_type, user_id)
VALUES (1, 100.00, 4, 1, 1),
		(2, 800.00, 3, 2, 2);


INSERT INTO users(user_id, username, first_name, last_name, email, user_password, user_role)
VALUES (1, 'neild', 'Neil', 'Damaraju', 'neil123@blahblah.com', 'password', 1 ),
		(2, 'samt', 'Sam', 'Taylor', 'sam.taylor@blahblah.com', 'password1', 3 );
