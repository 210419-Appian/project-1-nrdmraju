## Banking API

The Banking API will be used to manage the bank accounts and it's users. It will be managed by the Bank's administrators and employeees. The administrator and employee profiles are based off of the standard users but with additional capabilities.

## Features

* Employees can view all customer information, but not modify in any way.
* Admins can both view all user information, as well as directly modify it.
* Standard Users can register and login to see their account information.They can have either Checking or Savings accounts.
* All Users can update their personal information, such as username, password, first and last names, as well as email.
* User Accounts support withdrawals, deposits, and transfers.
* Transfer of funds are allowed between accounts owned by the same user, as well as between accounts owned by different users.

## To-Do:
* Support DELETE requests for Users and Accounts
* Use JSON Web Tokens (JWTs) instead of Session Storage
* Password Hashing
* Simulate Savings account interest rates.
* Paging and Sorting endpoints

## Technologies Used:
* AWS RDS
* Java 8
* PostgreSQL
* JDBC
* Maven
* Servlets
* Apache Tomcat 9
* Postman

## Getting Started: 
* Be sure to have Apache Tomcat 9 installed.
* Be sure to have the Java 8 runtime environment installed.
* git clone https://github.com/210419-Appian/project-1-nrdmraju

## Contributors: 
* Neil Damaraju
