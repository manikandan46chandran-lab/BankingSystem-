#  Simple Banking System (Java + JDBC + SQL)

A **console-based End-to-End (E2E) Mini Online Banking System** built using **Core Java, JDBC, and MySQL**.  
This project contains input validation, exception handling, and database interaction.

---

##  Features

### Authentication
- User Registration
- User Login
- Username & Password Validation
- Secure retry loops 

### Banking Operations
- Create Bank Account
- Deposit Money
- Withdraw Money
- Balance Enquiry
- Transaction History

### Backend Design
- JDBC 
- Custom Exceptions
- ResultSet handling
- Safe Scanner input handling (no infinite loops)

---

## Technologies Used

- **Java (Core Java)**
- **JDBC**
- **MySQL**
- **SQL**
- **Git & GitHub**

---
##  Database Schema

### Database
```sql
CREATE DATABASE mini_bank;
USE mini_bank;
Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

Accounts Table
CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    balance DOUBLE DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

Transactions Table
CREATE TABLE transactions (
    txn_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    type VARCHAR(20),
    amount DOUBLE,
    txn_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
