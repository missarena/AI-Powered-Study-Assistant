# 📚 AI-Powered Study Assistant

An AI-powered study assistant built using **Spring Boot**, **Spring Security**, **Thymeleaf**, **MySQL**, and **Spring AI (Ollama)**. The application allows users to securely manage notes and generate AI-powered summaries. It is deployed on **AWS EC2** with **Nginx** as a reverse proxy and managed using **systemd**.

---

## 🚀 Live Demo

**URL:** http://YOUR_PUBLIC_IP

> Example: http://13.53.245.80

---

## ✨ Features

- 🔐 User Registration & Login
- 👤 Role-Based Authentication & Authorization
- 📝 Create, Update & Delete Notes
- 🤖 AI-Powered Note Summarization using Ollama
- 🔒 Password Encryption with BCrypt
- 💾 MySQL Database Integration
- 🌐 Responsive UI with Thymeleaf
- ☁️ AWS EC2 Deployment
- ⚡ Nginx Reverse Proxy
- 🔄 Automatic Application Startup using systemd

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3.2
- Spring Security
- Spring Data JPA
- Hibernate
- Spring AI

### Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap

### Database
- MySQL

### AI
- Ollama
- Phi Model

### Build Tool
- Maven

### Deployment
- AWS EC2 (Ubuntu)
- Nginx
- systemd

---

## 📁 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── config
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── repository
│   │   ├── security
│   │   ├── service
│   │   └── SecurityTestApplication.java
│   │
│   └── resources
│       ├── static
│       ├── templates
│       ├── application.properties
│       └── ...
```

---

## ⚙️ Installation

### 1. Clone Repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/AI-Powered-Study-Assistant.git
cd AI-Powered-Study-Assistant
```

### 2. Configure MySQL

Create a database:

```sql
CREATE DATABASE study_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/study_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

### 3. Build the Project

```bash
mvn clean package
```

---

### 4. Run the Application

```bash
java -jar target/security_test-0.0.1-SNAPSHOT.jar
```

Application will start at:

```
http://localhost:8080
```

---

# ☁️ AWS Deployment

The application has been successfully deployed on **AWS EC2** using the following setup:

- Ubuntu Server
- Java 21
- MySQL
- Nginx Reverse Proxy
- Spring Boot Executable JAR
- systemd Service

Deployment Flow:

```
Developer
     │
     ▼
 GitHub Repository
     │
     ▼
 Maven Build
     │
     ▼
 Executable JAR
     │
     ▼
 Upload to EC2
     │
     ▼
 Spring Boot Service
     │
     ▼
 Nginx
     │
     ▼
 Browser
```

---

## 📸 Screenshots

### Login Page

> Add screenshot here

![Login](screenshots/login.png)

---

### Dashboard

> Add screenshot here

![Dashboard](screenshots/dashboard.png)

---

### Notes

> Add screenshot here

![Notes](screenshots/notes.png)

---

### AI Summary

> Add screenshot here

![AI Summary](screenshots/ai-summary.png)

---

## 🔮 Future Enhancements

- Email Verification
- Password Reset
- JWT Authentication
- Docker Deployment
- GitHub Actions CI/CD
- HTTPS with Let's Encrypt
- Custom Domain
- Redis Integration
- Note Sharing
- PDF Export

---

## 👩‍💻 Author

**Sadiya**

GitHub:
https://github.com/YOUR_GITHUB_USERNAME

LinkedIn:
https://linkedin.com/in/YOUR_LINKEDIN_PROFILE

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!
