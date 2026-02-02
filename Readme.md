# 🏦 Mini Online Banking System (Java + JDBC + SQL)

A **console-based End-to-End (E2E) Mini Online Banking System** built using **Core Java, JDBC, and MySQL**.  
This project demonstrates **real-world backend concepts** such as layered architecture, input validation, exception handling, and database interaction.

---

##  Features

### Authentication
- User Registration
- User Login
- Username & Password Validation
- Secure retry loops (no forced exits)

### Banking Operations
- Create Bank Account (auto-managed)
- Deposit Money
- Withdraw Money
- Balance Enquiry
- Transaction History

### Backend Design
- Layered Architecture (DAO → Service → Main)
- JDBC with PreparedStatements
- Custom Exceptions
- Defensive ResultSet handling
- Safe Scanner input handling (no infinite loops)

---

## 🗂️ Project Structure
MiniBankingSystem/
│
├── db/
│ └── DBConnection.java
│
├── dao/
│ ├── UserDAO.java
│ ├── AccountDAO.java
│ └── TransactionDAO.java
│
├── service/
│ └── BankingService.java
│
├── exception/
│ ├── AuthenticationException.java
│ └── InsufficientBalanceException.java
│
├── util/
│ └── InputValidator.java
│
└── Main.java

---

## 🛠️ Technologies Used

- **Java (Core Java)**
- **JDBC**
- **MySQL**
- **SQL**
- **Git & GitHub**

---

## 🗄️ Database Schema

### Database
```sql
CREATE DATABASE mini_bank;
USE mini_bank;
