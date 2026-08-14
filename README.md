# Smart Parking Management System (SPMS)

A cloud-native, microservices-based backend application designed to efficiently manage parking spaces, vehicle registrations, user profiles, and payments. This project demonstrates professional architectural patterns, including the **database-per-service** strategy and a centralized API Gateway.

## 🏗️ System Architecture

This project is built using a modern microservices architecture with Spring Boot and Spring Cloud. 

### Core Infrastructure Services
* **API Gateway:** Acts as the single entry point for all client requests, routing them to the appropriate microservices.
* **Service Registry (Eureka):** Enables dynamic service discovery. All microservices register themselves here.
* **Config Server:** Centralized configuration management for all microservices across different environments.

### Business Microservices
* **User Service:** Manages user registration, profiles, and authentication data.
* **Vehicle Service:** Handles vehicle registration and owner mapping.
* **Parking Space Service:** Manages the availability, location, and status of parking slots.
* **Payment Service:** Processes parking fees and transaction records.

## 🚀 Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Cloud Capabilities:** Spring Cloud (Netflix Eureka, API Gateway, Config)
* **Database:** MySQL (Database-per-service pattern)
* **Build Tool:** Maven
* **Version Control:** Git & GitHub (Feature-branching workflow)

## 🗄️ Database Strategy

To maintain loose coupling and high independence between services, this project strictly adheres to the **Database-per-Service** pattern. Each core microservice has its own isolated MySQL database schema:
* `spms_user_db`
* `spms_vehicle_db`
* `spms_parking_db`
* `spms_payment_db`

## 📡 API Testing (Postman)

To make testing easy, a complete Postman collection has been generated containing all the endpoints for every microservice.
* **Postman Collection Path:** [`SPMS_Postman_Collection.json`](./SPMS_Postman_Collection.json)
* **How to use:** Simply open Postman, click **Import**, and drag & drop this file. It contains pre-configured request bodies and routes all traffic through the API Gateway (Port 8080).

## 🟢 Service Registration Dashboard

When all services are running successfully, they register themselves with the Eureka Server. You can monitor the health and status of the services via the Eureka Dashboard (`http://localhost:8761`).

![Eureka Dashboard showing active services](assets/eureka-dashboard.webp)

## 🛠️ How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Sadeepa123L/Smart-Parking-Management-System.git
   cd Smart-Parking-Management-System
   ```

2. **Start the Database:** Ensure MySQL is running on port 3306.

3. **Start the Microservices:** 
   * Run the services in the following order: `config-server` ➔ `eureka-server` ➔ `user-service`, `vehicle-service`, `parking-space-service`, `payment-service` ➔ `api-gateway`.
   * Or use the provided PowerShell automation script:
   ```bash
   ./start-all.ps1
   ```
