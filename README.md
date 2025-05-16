# 🏦 Banking Web Application – Secure Transaction System

A full-stack banking system enabling user registration, secure login, account balance management, and transaction history tracking. Built using Spring Boot, Spring Security, Thymeleaf, and MySQL.

---

## 🔧 Tech Stack

- **Backend:** Java, Spring Boot, Spring Security, Spring Data JPA
- **Frontend:** Thymeleaf
- **Database:** MySQL
- **Build Tool:** Maven

---

## 🔐 Core Features

- User Registration and Login (Spring Security)
- Role-Based Access Control (Admin/User)
- Account Balance Display and Updates
- Secure Withdrawal Functionality
- Transaction History with Timestamp
- Responsive UI using Thymeleaf

---

## 🚀 How to Run

1. **Clone the project**
   ```bash
   git clone https://github.com/your-username/banking-web-app.git
   cd banking-web-app

2. Configure MySQL

2. Create a DB named bankappdb

3. Update src/main/resources/application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/banking_system <br>
    spring.datasource.username=YOUR_USERNAME <br>
    spring.datasource.password=YOUR_PASSWORD <br>
    spring.jpa.hibernate.ddl-auto=update <br>

4. Run the App <br>
./mvnw spring-boot:run  <br>
Or run via IDE.  <br>

5. Open in Browser  <br>
http://localhost:8080
